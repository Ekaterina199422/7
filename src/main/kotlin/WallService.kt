import attachments.*
import java.time.LocalDateTime
import java.time.ZoneOffset

object WallService : WallServiceCore() {
}

fun main() {

    val attachment: Attachment = AttachmentLink(
            attachmentContent = Link(
                    url = "www.netology.ru", title = "-=Курсы выживания без связи=-", "", "",
                    product = LinkProduct(
                            LinkProduct.Price(100500, LinkProduct.Currency(1, "RUP (российских рублей)"), text = "цена"),
                    )
            )
    )
    WallService.add(
            Post(
                    date = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC),
                    text = "Скоро Конец Света!\nУспей хакни скиллы  тотального блэкаута!",
                    attachments = arrayOf(attachment)
            )
    )

    WallService.createComment(
            Comment(
                    replyToComment = WallService.getLastPostId(),
                    message = "плачу 100502!", ownerId = 1, postId = 1
            )
    )
    WallService.createComment(
            Comment(
                    replyToComment = WallService.getLastPostId(),
                    message = "Кто здесь?", ownerId = 2, postId = 2
            )
    )
    WallService.createComment(
            Comment(
                    replyToComment = WallService.getLastPostId(),
                    message = "Казино казино - подними деньжат!", ownerId = 3, postId = 3
            )
    )
    WallService.createComment(
            Comment(
                    replyToComment = WallService.getLastPostId(),
                    message = "Казино везде!", ownerId = 2, postId = 4
            )
    )

    WallService.reportComment(3, ReportReason.SPAM)
    WallService.reportComment(4, ReportReason.EXTREMISM)

    WallService.findPostById(WallService.getLastPostId())?.let { postPrint(it) }

}


fun postPrint(post: Post) {
    println(post.text)
    for ((_, att) in post.attachments?.withIndex()!!) {
        when (att) {
            is AttachmentLink -> {
                println(att.attachmentContent.title)
                println("юда ${att.attachmentContent.url}")
                println(
                        "цена всего ${att.attachmentContent.product?.price?.amount} " +
                                "${att.attachmentContent.product?.price?.currency?.name} !"
                )
            }
            is AttachmentVideo -> println("Смотри")
            is AttachmentDoc -> println("Читай")
            is AttachmentPhoto -> println("Смотри")
            is AttachmentAudio -> println("Слушай")
        }
    }
    println("copyright ${post.copyright}")

    val commentString = WallService.getPostComments(post)
    if (commentString.isNotEmpty()) {
        println("\nКомментарии:")
        println(commentString)
    }


}