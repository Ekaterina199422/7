import org.junit.Assert.*
import org.junit.Test
import ru.netology.exception.*
import ru.netology.wall.*
import ru.netology.service.*


class WallServiceTest {
    private val service = WallService()

    @Test
    fun addPost() {
        val result = service.add(
                Post(
                        ownerId = 0,
                        fromId = 0,
                        createdBy = 0,
                        date = 1601510399,
                        text = "this text post",
                        replyOwnerId = 0,
                        replyPostId = 0,
                        friendsOnly = true,
                        comments = Comments(
                                count = 1,
                                canPost = true,
                                groupCanPost = true,
                                canClose = false,
                                canOpen = false
                        ),
                        copyright = "copyright1",
                        likes = Likes(count = 1, userLikes = true, canLike = false, canPublish = false),
                        reposts = Reposts(count = 1, userReposted = false),
                        views = Views(1),
                        postType = "post",
                        postSource = null,
                        attachments = null,
                        geo = null,
                        signerId = 0,
                        canPin = true,
                        canDelete = true,
                        canEdit = true,
                        isPinned = true,
                        markedAsAds = true,
                        isFavorite = true,
                        postponedId = 1
                )
        )
        assertEquals(result.id, 1)
    }

    @Test
    fun updateExistingTrue() {
        service.add(
                Post(
                        ownerId = 0,
                        fromId = 0,
                        createdBy = 0,
                        date = 1601510399,
                        text = "this text post",
                        replyOwnerId = 0,
                        replyPostId = 0,
                        friendsOnly = true,
                        comments = Comments(
                                count = 1,
                                canPost = true,
                                groupCanPost = true,
                                canClose = false,
                                canOpen = false
                        ),
                        copyright = "copyright1",
                        likes = Likes(count = 1, userLikes = true, canLike = false, canPublish = false),
                        reposts = Reposts(count = 1, userReposted = false),
                        views = Views(1),
                        postType = "post",
                        postSource = null,
                        attachments = null,
                        geo = null,
                        signerId = 0,
                        canPin = true,
                        canDelete = true,
                        canEdit = true,
                        isPinned = true,
                        markedAsAds = true,
                        isFavorite = true,
                        postponedId = 1
                )
        )

        val updatePost = Post(
                id = 1,
                ownerId = 0,
                fromId = 0,
                createdBy = 0,
                date = 1601510500,
                text = "this update text post",
                replyOwnerId = 0,
                replyPostId = 0,
                friendsOnly = true,
                comments = Comments(count = 1, canPost = true, groupCanPost = true, canClose = false, canOpen = false),
                copyright = "copyright1",
                likes = Likes(count = 1, userLikes = true, canLike = false, canPublish = false),
                reposts = Reposts(count = 1, userReposted = false),
                views = Views(1),
                postType = "post",
                postSource = null,
                attachments = null,
                geo = null,
                signerId = 0,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = true,
                isFavorite = true,
                postponedId = 1
        )
        val result = service.update(updatePost)
        assertTrue("true", result)
    }

    @Test
    fun updateExistingFalse() {
        service.add(
                Post(
                        ownerId = 0,
                        fromId = 0,
                        createdBy = 0,
                        date = 1601510399,
                        text = "this text post",
                        replyOwnerId = 0,
                        replyPostId = 0,
                        friendsOnly = true,
                        comments = Comments(
                                count = 1,
                                canPost = true,
                                groupCanPost = true,
                                canClose = false,
                                canOpen = false
                        ),
                        copyright = "copyright1",
                        likes = Likes(count = 1, userLikes = true, canLike = false, canPublish = false),
                        reposts = Reposts(count = 1, userReposted = false),
                        views = Views(1),
                        postType = "post",
                        postSource = null,
                        attachments = null,
                        geo = null,
                        signerId = 0,
                        canPin = true,
                        canDelete = true,
                        canEdit = true,
                        isPinned = true,
                        markedAsAds = true,
                        isFavorite = true,
                        postponedId = 1
                )
        )

        val updatePost = Post(
                id = 45,
                ownerId = 0,
                fromId = 0,
                createdBy = 0,
                date = 1601510500,
                text = "this update text post",
                replyOwnerId = 0,
                replyPostId = 0,
                friendsOnly = true,
                comments = Comments(count = 1, canPost = true, groupCanPost = true, canClose = false, canOpen = false),
                copyright = "copyright1",
                likes = Likes(count = 1, userLikes = true, canLike = false, canPublish = false),
                reposts = Reposts(count = 1, userReposted = false),
                views = Views(1),
                postType = "post",
                postSource = null,
                attachments = null,
                geo = null,
                signerId = 0,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = true,
                isFavorite = true,
                postponedId = 1
        )
        val result = service.update(updatePost)
        assertFalse("false", result)
    }

    @Test
    fun createCommentNoExcept() {
        service.add(
                Post(
                        ownerId = 0,
                        fromId = 0,
                        createdBy = 0,
                        date = 1601510399,
                        text = "this text post",
                        replyOwnerId = 0,
                        replyPostId = 0,
                        friendsOnly = true,
                        comments = Comments(
                                count = 1,
                                canPost = true,
                                groupCanPost = true,
                                canClose = false,
                                canOpen = false
                        ),
                        copyright = "copyright1",
                        likes = Likes(count = 1, userLikes = true, canLike = false, canPublish = false),
                        reposts = Reposts(count = 1, userReposted = false),
                        views = Views(1),
                        postType = "post",
                        postSource = null,
                        attachments = null,
                        geo = null,
                        signerId = 0,
                        canPin = true,
                        canDelete = true,
                        canEdit = true,
                        isPinned = true,
                        markedAsAds = true,
                        isFavorite = true,
                        postponedId = 1
                )
        )

        service.createComment(
                postId = 1,
                comment = Comment(
                        ownerId = 0,
                        date = 1234567,
                        text = "text comment",
                        replyToUser = 0,
                        replyToComment = 0,
                        attachments = null,
                        parentsStack = null,
                        thread = null
                )
        )


    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {

        service.add(
                Post(
                        ownerId = 0,
                        fromId = 0,
                        createdBy = 0,
                        date = 1601510399,
                        text = "this text post",
                        replyOwnerId = 0,
                        replyPostId = 0,
                        friendsOnly = true,
                        comments = Comments(
                                count = 1,
                                canPost = true,
                                groupCanPost = true,
                                canClose = false,
                                canOpen = false
                        ),
                        copyright = "copyright1",
                        likes = Likes(count = 1, userLikes = true, canLike = false, canPublish = false),
                        reposts = Reposts(count = 1, userReposted = false),
                        views = Views(1),
                        postType = "post",
                        postSource = null,
                        attachments = null,
                        geo = null,
                        signerId = 0,
                        canPin = true,
                        canDelete = true,
                        canEdit = true,
                        isPinned = true,
                        markedAsAds = true,
                        isFavorite = true,
                        postponedId = 1
                )
        )

        service.createComment(
                postId = 10,
                comment = Comment(
                        ownerId = 0,
                        date = 1234567,
                        text = "text comment",
                        replyToUser = 0,
                        replyToComment = 0,
                        attachments = null,
                        parentsStack = null,
                        thread = null
                )
        )

    }


    @Test
    fun createReportCommentNoExcept() {
        service.add(
                Post(
                        ownerId = 0,
                        fromId = 0,
                        createdBy = 0,
                        date = 1601510399,
                        text = "this text post",
                        replyOwnerId = 0,
                        replyPostId = 0,
                        friendsOnly = true,
                        comments = Comments(
                                count = 1,
                                canPost = true,
                                groupCanPost = true,
                                canClose = false,
                                canOpen = false
                        ),
                        copyright = "copyright1",
                        likes = Likes(count = 1, userLikes = true, canLike = false, canPublish = false),
                        reposts = Reposts(count = 1, userReposted = false),
                        views = Views(1),
                        postType = "post",
                        postSource = null,
                        attachments = null,
                        geo = null,
                        signerId = 0,
                        canPin = true,
                        canDelete = true,
                        canEdit = true,
                        isPinned = true,
                        markedAsAds = true,
                        isFavorite = true,
                        postponedId = 1
                )
        )

        service.createComment(
                postId = 1,
                comment = Comment(
                        ownerId = 0,
                        date = 1234567,
                        text = "text comment",
                        replyToUser = 0,
                        replyToComment = 0,
                        attachments = null,
                        parentsStack = null,
                        thread = null
                )
        )
        service.reportComment(commentId = 1, reason = 1)
    }

    @Test(expected = ReasonArrayIndexOut::class)
    fun shouldReportCommentThrowReason() {
        service.add(
                Post(
                        ownerId = 0,
                        fromId = 0,
                        createdBy = 0,
                        date = 1601510399,
                        text = "this text post",
                        replyOwnerId = 0,
                        replyPostId = 0,
                        friendsOnly = true,
                        comments = Comments(
                                count = 1,
                                canPost = true,
                                groupCanPost = true,
                                canClose = false,
                                canOpen = false
                        ),
                        copyright = "copyright1",
                        likes = Likes(count = 1, userLikes = true, canLike = false, canPublish = false),
                        reposts = Reposts(count = 1, userReposted = false),
                        views = Views(1),
                        postType = "post",
                        postSource = null,
                        attachments = null,
                        geo = null,
                        signerId = 0,
                        canPin = true,
                        canDelete = true,
                        canEdit = true,
                        isPinned = true,
                        markedAsAds = true,
                        isFavorite = true,
                        postponedId = 1
                )
        )

        service.createComment(
                postId = 1,
                comment = Comment(
                        ownerId = 0,
                        date = 1234567,
                        text = "text comment",
                        replyToUser = 0,
                        replyToComment = 0,
                        attachments = null,
                        parentsStack = null,
                        thread = null
                )
        )
        service.reportComment(commentId = 1, reason = 10)
    }

    @Test(expected = CommentNotFoundException::class)
    fun shouldReportCommentThrow() {
        service.add(
                Post(
                        ownerId = 0,
                        fromId = 0,
                        createdBy = 0,
                        date = 1601510399,
                        text = "this text post",
                        replyOwnerId = 0,
                        replyPostId = 0,
                        friendsOnly = true,
                        comments = Comments(
                                count = 1,
                                canPost = true,
                                groupCanPost = true,
                                canClose = false,
                                canOpen = false
                        ),
                        copyright = "copyright1",
                        likes = Likes(count = 1, userLikes = true, canLike = false, canPublish = false),
                        reposts = Reposts(count = 1, userReposted = false),
                        views = Views(1),
                        postType = "post",
                        postSource = null,
                        attachments = null,
                        geo = null,
                        signerId = 0,
                        canPin = true,
                        canDelete = true,
                        canEdit = true,
                        isPinned = true,
                        markedAsAds = true,
                        isFavorite = true,
                        postponedId = 1
                )
        )

        service.createComment(
                postId = 1,
                comment = Comment(
                        ownerId = 0,
                        date = 1234567,
                        text = "text comment",
                        replyToUser = 0,
                        replyToComment = 0,
                        attachments = null,
                        parentsStack = null,
                        thread = null
                )
        )
        service.reportComment(commentId = 10, reason = 1)


    }
}