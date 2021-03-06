package pbandk

@PublicForGeneratedCode
class ListWithSize<T> internal constructor(val list: List<T>, val protoSize: Int?) : List<T> by list {
    constructor(list: List<T>, sizeFn: (T) -> Int) : this(list, list.sumBy(sizeFn))

    override fun equals(other: Any?) = list == other
    override fun hashCode() = list.hashCode()
    override fun toString() = list.toString()

    class Builder<T> private constructor(val list: ArrayList<T>): MutableList<T> by list {
        constructor() : this(ArrayList())

        fun fixed() = ListWithSize(list.also { it.trimToSize() }, protoSize = null)

        companion object {
            fun <T> fixed(bld: Builder<T>?) = bld?.fixed() ?: Empty
        }
    }

    companion object {
        val Empty = ListWithSize(emptyList<Nothing>(), 0)
    }
}