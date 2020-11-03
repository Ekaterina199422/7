package ru.netology.wall

import ru.netology.attachments.*

class Comment(
    var id: Int = 0,
    val ownerId: Int,
    val date: Int,
    val text: String,
    val replyToUser: Int,
    val replyToComment: Int,
    val attachments: Attachments?,
    var parentsStack: Array<Int>?,
    val thread: Thread?
) {

}