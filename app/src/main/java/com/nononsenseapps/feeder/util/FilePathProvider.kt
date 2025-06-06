package com.nononsenseapps.feeder.util

import java.io.File

/**
 * An interface providing the paths to relevant directories to place files
 */
interface FilePathProvider {
    val cacheDir: File
    val filesDir: File

    /**
     * This is where articles regular text should be placed
     */
    val articleDir: File

    /**
     * This is where the full text of articles should be placed
     */
    val fullArticleDir: File

    /**
     * Where fonts should be placed
     */
    val fontsDir: File

    /**
     * Where http cache should reside
     */
    val httpCacheDir: File

    /**
     * Where images should be cached to
     */
    val imageCacheDir: File

    /**
     * Where images should be cached to for okhttp
     */
    val httpImageCacheDir: File
}

private class FilePathProviderImpl(
    override val cacheDir: File,
    override val filesDir: File,
) : FilePathProvider {
    override val articleDir: File = filesDir.resolve("articles")
    override val fullArticleDir: File = cacheDir.resolve("full_articles")
    override val httpCacheDir: File = cacheDir.resolve("http")
    override val imageCacheDir: File = cacheDir.resolve("image_cache")
    override val httpImageCacheDir: File = cacheDir.resolve("http_image_cache")
    override val fontsDir: File = filesDir.resolve("fonts")
}

fun filePathProvider(
    cacheDir: File,
    filesDir: File,
): FilePathProvider = FilePathProviderImpl(cacheDir = cacheDir, filesDir = filesDir)
