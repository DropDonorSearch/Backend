package ru.donorsearch.controller

import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/media")
class MediaController {

    @GetMapping("/{filename:.+}")
    fun serveFile(@PathVariable filename: String): ResponseEntity<ByteArray> {
        val resource = ClassPathResource("media/$filename")
        if (resource.exists()) {
            val fileContent = resource.inputStream.readAllBytes()
            return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(fileContent)
        }
        return ResponseEntity.notFound().build()
    }
}