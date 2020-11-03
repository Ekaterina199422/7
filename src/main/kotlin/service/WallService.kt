package ru.netology.service
import ru.netology.attachments.*
import ru.netology.exception.*
import ru.netology.wall.*

object WallService {
    private var postsArray = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<Report>()
    private var idPost = 0
    private var idComment = 0

    fun add(post: Post): Post {
        idPost += 1
        post.id = idPost
        postsArray += post
        return postsArray.last()
    }

    fun update(post: Post): Boolean {
        for ((index, posts) in postsArray.withIndex()) {
            if (post.id == posts.id) {
                postsArray[index] = post.copy(
                        ownerId = posts.ownerId,
                        date = posts.date
                )
                return true
            }
        }
        return false
    }

    fun reportComment(commentId: Int, reason: Int) {
        val reasonList: List<String> = listOf(
                "спам",
                "детская порнография",
                "экстремизм",
                "насилие",
                "пропаганда наркотиков",
                "материал для взрослых",
                "оскорбление",
                "призывы к суициду"
        )
        try {
            for (comment in comments) {
                if (comment.id == commentId) {
                    reports += Report(reason = reasonList[reason], comment)
                    return
                }
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
            throw ReasonArrayIndexOut("index=$reason not found")
        }
        throw CommentNotFoundException("comment id=$commentId not found")
    }

    fun createComment(comment: Comment) {
        for (post in postsArray) {
            if (postId == post.id) {
                idComment += 1
                comment.id = idComment
                comments += comment
                return
            }
        }
        throw PostNotFoundException("post id=$postId not found")
    }

    fun readArray() {
        for (post in postsArray) {
            val attachments: Array<Attachments> = post.attachments ?: emptyArray()
            for (attachment in attachments) {
                when (attachment) {
                    is NoteAttachments -> {
                        val note: Note = attachment.note
                        println("date: ${note.date}")
                        println("text: ${note.text}")
                        println("title: ${note.title}")
                    }
                    is PhotoAttachments -> {
                        val photo: Photo = attachment.photo
                        println("id: ${photo.albumId}")
                        println("text: ${photo.text}")
                        println("date: ${photo.date}")
                    }
                    is AudioAttachments -> {
                        val audio: Audio = attachment.audio
                    }
                    is EventAttachments -> {
                        val event: Event = attachment.event
                    }
                    is VideoAttachments -> {
                        val video: Video = attachment.video
                    }
                }
            }
        }
    }
}
