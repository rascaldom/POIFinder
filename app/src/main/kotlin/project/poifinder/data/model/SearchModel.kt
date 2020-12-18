package project.poifinder.data.model

data class SearchModel (
    val lastBuildDate: String,
    val total: Long,
    val start: Long,
    val display: Long,
    val items: List<Item>
)

data class Item (
    val title: String,
    val link: String,
    val category: String,
    val description: String,
    val telephone: String,
    val address: String,
    val roadAddress: String,
    val mapx: Double,
    val mapy: Double
)