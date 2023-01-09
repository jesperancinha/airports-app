package org.jesperancinha.airports

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class AirportsAppLauncher : SpringBootServletInitializer() {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(AirportsAppLauncher::class.java)
        }
    }

}