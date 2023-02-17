package com.sample.albertson_coding_challenge.model

data class AcromineData(
    val sf: String? = null,
    val lfs: Array<Lfs>? = null
)

data class Lfs(
    val lf: String? = null,
    val freq: Int? = null,
    val since: Int? = null,
    val vars: Array<Variations>? = null
)

data class Variations(
    val lf: String? = null,
    val freq: Int? = null,
    val since: Int? = null
)