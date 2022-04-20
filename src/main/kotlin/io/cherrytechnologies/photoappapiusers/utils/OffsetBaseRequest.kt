package io.cherrytechnologies.photoappapiusers.utils


//import org.springframework.data.domain.PageRequest
//import org.springframework.data.domain.Pageable
//import org.springframework.data.domain.Sort
//
//class OffsetBasedPageRequest(
//    private val limit: Int,
//    private val offset: Int,
//    private val sort: Sort = Sort.by(Sort.Direction.ASC, "id")
//) : Pageable {
//
//    init {
//        if (limit < 1) {
//            throw BadRequestException("Limit must not be less than one!");
//        }
//        if (offset < 0) {
//            throw BadRequestException("Offset index must not be less than zero!");
//        }
//    }
//
//    override fun getPageNumber() = offset / limit
//
//    override fun getPageSize() = limit
//
//    override fun getOffset() = offset.toLong()
//
//    override fun getSort(): Sort = sort
//
//    override fun next() = OffsetBasedPageRequest(pageSize, (getOffset() + pageSize).toInt())
//
//    private fun previous() =
//        if (hasPrevious()) OffsetBasedPageRequest(pageSize, (getOffset() - pageSize).toInt()) else this
//
//    override fun previousOrFirst() = if (hasPrevious()) previous() else first();
//
//    override fun first() = OffsetBasedPageRequest(pageSize, 0);
//
//    override fun withPage(pageNumber: Int) = PageRequest.ofSize(pageNumber)
//
//
//    override fun hasPrevious() = offset > limit;
//
//}