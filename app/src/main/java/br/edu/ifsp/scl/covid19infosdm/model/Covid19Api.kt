package br.edu.ifsp.scl.sdm.covid19infosdm.model

import br.edu.ifsp.scl.sdm.covid19infosdm.model.dataclass.ByCountryResponseList
import br.edu.ifsp.scl.sdm.covid19infosdm.model.dataclass.DayOneResponseList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

object Covid19Api {
    val BASE_URL = "https://api.covid19api.com/"

    /*"Name": "GET Countries",
    "Description": "Returns all the available countries and provinces, as well as the country slug for per country requests.",
    "Path": "/countries",
    "Params": null*/
    val COUNTRIES_ENDPOINT = "countries"

    interface RetrofitServices {
        /*"Name": "GET Day One",
        "Description": "Returns all cases by case type for a country from the first recorded case. Country must be the Slug from /countries or /summary. Cases must be one of: confirmed, recovered, deaths",
        "Path": "/dayone/country/{country}/status/{status}",
        "Params": [
            "country",
            "status"
        ]*/
        @GET("dayone/country/{countryName}/status/{status}")
        fun getDayOne(
            @Path("countryName") countryName: String,
            @Path("status") status: String
        ): Call<DayOneResponseList>

        /*"Name": "GET By Country",
        "Description": "Returns all cases by case type for a country. Country must be the slug from /countries or /summary. Cases must be one of: confirmed, recovered, deaths",
        "Path": "/country/{country}/status/{status}",
        "Params": [
            "country",
            "status"
        ]*/
        @GET("country/{countryName}/status/{status}")
        fun getByCountry(
            @Path("countryName") countryName: String,
            @Path("status") status: String
        ): Call<ByCountryResponseList>
    }
}