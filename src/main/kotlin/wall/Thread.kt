package ru.netology.wall

class Thread(
    val count: Int,
    var items: Array<Comment>?,
    val canPost: Boolean,
    val showReplyButton: Boolean,
    val groupsCanPost: Boolean
) {
}