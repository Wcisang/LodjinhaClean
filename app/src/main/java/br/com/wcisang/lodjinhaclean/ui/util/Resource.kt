package br.com.wcisang.lodjinhaclean.ui.util

class Resource<out T> constructor(val status: ResourceState, val data: T? = null, val message: String? = null) {

    companion object {

        fun <T> loading(): Resource<T> = Resource(ResourceState.LOADING)

        fun <T> success(data: T?) : Resource<T> = Resource(ResourceState.SUCCESS, data)

        fun <T> success(data: T?, message: String?) : Resource<T> = Resource(ResourceState.SUCCESS, data, message)

        fun <T> success() : Resource<T> = Resource(ResourceState.SUCCESS)

        fun <T> error(message: String?) : Resource<T> = Resource(ResourceState.ERROR, message = message)

        }
}