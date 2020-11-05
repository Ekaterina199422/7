import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    @Test
    fun add() {
        val service = WallServiceCore()
        val expected = service.getLastPostId() + 1
        service.add(post = Post())
        assertEquals(expected, service.getLastPostId())
    }

    @Test
    fun updateExisting() {
        val service = WallServiceCore()
        service.add(Post(text = "1сообщение"))
        service.add(Post(text = "2сообщение"))
        service.add(Post())

        val updatePost = Post(2, text = "2сообщение обновлено")
        val result = service.update(updatePost)
        assertTrue(result)

    }

    @Test
    fun updateNotExisting() {
        val service = WallServiceCore()
        service.add(Post(text = "1сообщение"))
        service.add(Post(text = "2сообщение"))
        service.add(Post(text = "3сообщение"))

        val updatePost = Post(7, text = "2обновлено")
        val result = service.update(updatePost)
        assertTrue(!result)
    }

    @Test
    fun findPostById() {
        val service = WallServiceCore()
        service.add(Post(text = "1сообщение"))
        val expected = service.add(Post(text = "2сообщение"))
        service.add(Post(text = "3сообщение"))
        assertEquals(expected, service.findPostById(2))
    }

    @Test
    fun createComment() {
        val service = WallServiceCore()
        val post = Post(text = "будет комментарий")
        service.add(post)

        val comment = Comment(
                replyToComment = service.getLastPostId(), message = "comment",
                ownerId = 1, postId = 1,
                attachments = arrayOf(CommentAttachment("att", 1, 1))
        )

        service.createComment(comment)
        val result = service.findPostById(service.getLastPostId())?.let { service.getPostComments(it) }

        assertEquals("- comment\n", result)
    }

    @Test(expected = CommentNotFoundException::class)
    fun reportCommentShouldThrow() {
        val service = WallServiceCore()
        val post = Post(text = "будет комментарий")
        service.add(post)

        val comment = Comment(
                replyToComment = service.getLastPostId(), message = "comment",
                ownerId = 1, postId = 1,
                attachments = arrayOf(CommentAttachment("att", 1, 1))
        )

        service.createComment(comment)
        service.reportComment(10, ReportReason.NARCOTICS)
    }

    @Test
    fun reportComment() {
        val service = WallServiceCore()
        val post = Post(text = "будет комментарий")
        service.add(post)

        val comment = Comment(
                replyToComment = service.getLastPostId(), message = "comment",
                ownerId = 1, postId = 1,
                attachments = arrayOf(CommentAttachment("att", 1, 1))
        )

        service.createComment(comment)
        service.reportComment(1, ReportReason.NARCOTICS)
        val result = service.findPostById(service.getLastPostId())?.let { service.getPostComments(it) }
        assertNotEquals("", result)


    }


}