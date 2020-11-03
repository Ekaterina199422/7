package ru.netology.attachments

sealed class Attachments {
    abstract val type: String
}
data class AudioAttachments(override val type: String = "audio", val audio: Audio) : Attachments()
data class EventAttachments(override val type: String = "event", val event: Event) : Attachments()
data class NoteAttachments(override val type: String = "note", val note: Note) : Attachments()
data class PhotoAttachments(override val type: String = "photo", val photo: Photo) : Attachments()
data class VideoAttachments(override val type: String = "note", val video: Video) : Attachments()