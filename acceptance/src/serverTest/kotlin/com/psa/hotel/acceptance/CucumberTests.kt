package com.psa.hotel.acceptance

import io.cucumber.junit.*
import org.junit.runner.*

@RunWith(Cucumber::class)
@CucumberOptions(features = ["src/commonTest/resources"],
                tags = "@server and not @ignore")
class CucumberTests
