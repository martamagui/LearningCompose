package com.plcoding.weatherapp.data.location

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.plcoding.weatherapp.domain.location.LocationTracker
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class DefaultLocationTracker(
    //Recoger la geolocalización
    private val locationClient: FusedLocationProviderClient,
    //Para poder pedir los permisos
    private val application: Application
) : LocationTracker {
    override suspend fun getCurrentLocation(): Location? {
        val hasAccessFineLocationPermission = ContextCompat.checkSelfPermission(
            application, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val hasAccessCoarseLocationPermission = ContextCompat.checkSelfPermission(
            application, Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val locationManager = application.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

        if (!hasAccessCoarseLocationPermission || !hasAccessFineLocationPermission || !isGpsEnabled) {
            return null
        }

        //Retorna una tarea asíncrona que retornará la localización
        return suspendCancellableCoroutine { cont ->
            locationClient.lastLocation.apply {
                if (isComplete) {
                    //Una vez ha sido completada, retornará el la posición si ha sido exitosa
                    if (isSuccessful)
                        cont.resume(result)
                    else
                        cont.resume(null)
                    return@suspendCancellableCoroutine
                }
                addOnSuccessListener { cont.resume(it) }
                addOnFailureListener { cont.resume(null) }
                addOnCanceledListener { cont.cancel() }
                //Cancelaría la corrutina para que no se siga ejecutando.
            }
        }
    }
}