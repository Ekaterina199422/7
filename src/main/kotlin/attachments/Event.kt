package ru.netology.attachments

class Event(
    var id: Int,
    val time: Int,
    val memberStatus: Int,
    val isFavorite: Boolean,
    val address: String,
    val text: String,
    val buttonText: String,
    var friends: List<Int>

) {
}