package com.example.learningcompose

import java.lang.reflect.Type

data class MediaItem(
    val id:Int,
    val title: String,
    val thumb:String,
    val type: Type
){
    enum class Type {PHOTO, VIDEO}
}

fun getMedia()=(1..10).map{

    MediaItem(
        id= it,
        title = "Title $it",
        thumb = "https://media.istockphoto.com/photos/closeup-portrait-of-funny-ginger-cat-wearing-sunglasses-isolated-on-picture-id1188445864?k=20&m=1188445864&s=612x612&w=0&h=0vuJeOxJr8Lu3Q1VdT1z7t6HcM8Oj7EVJe3CexGnH_8=",
        type = if(it%3 ==0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
    )
}