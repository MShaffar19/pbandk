@file:OptIn(pbandk.PublicForGeneratedCode::class)

package pbandk.wkt

data class SourceContext(
    val fileName: String = "",
    override val unknownFields: Map<Int, pbandk.UnknownField> = emptyMap()
) : pbandk.Message {
    override operator fun plus(other: pbandk.Message?) = protoMergeImpl(other)
    override val fieldDescriptors get() = Companion.fieldDescriptors
    override val protoSize by lazy { super.protoSize }
    companion object : pbandk.Message.Companion<SourceContext> {
        val defaultInstance by lazy { SourceContext() }
        override fun unmarshal(u: pbandk.MessageUnmarshaller) = SourceContext.unmarshalImpl(u)

        override val fieldDescriptors: List<pbandk.FieldDescriptor<*>> by lazy {
            listOf(
                pbandk.FieldDescriptor(
                    name = "file_name",
                    number = 1,
                    type = pbandk.FieldDescriptor.Type.Primitive.String(),
                    jsonName = "fileName",
                    value = SourceContext::fileName
                )
            )
        }
    }
}

fun SourceContext?.orDefault() = this ?: SourceContext.defaultInstance

private fun SourceContext.protoMergeImpl(plus: pbandk.Message?): SourceContext = (plus as? SourceContext)?.copy(
    unknownFields = unknownFields + plus.unknownFields
) ?: this

@Suppress("UNCHECKED_CAST")
private fun SourceContext.Companion.unmarshalImpl(u: pbandk.MessageUnmarshaller): SourceContext {
    var fileName = ""

    val unknownFields = u.readMessage(this) { _fieldNumber, _fieldValue ->
        when (_fieldNumber) {
            1 -> fileName = _fieldValue as String
        }
    }
    return SourceContext(fileName, unknownFields)
}