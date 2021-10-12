package ge.nlatsabidze.tasktwelve

import android.util.Log
import android.util.Log.d
import android.util.Log.i
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject

class MainViewModel : ViewModel() {

    val jsonObject = JSONObject(
        "{\n" +
                "        \"id\": \"1cb040bd-f949-497d-8a54-ae3e8d90ee8c\",\n" +
                "        \"projectId\": \"9176539b-86bb-4c04-9de1-656d198e1cb2\",\n" +
                "        \"equipmentId\": \"c7d6e8a7-9ad8-4805-9c33-cf21a5c039a9\",\n" +
                "        \"status\": \"PENDING\",\n" +
                "        \"requestedBy\": \"823463c7-6bb5-48b4-8718-6a661558ee73\",\n" +
                "        \"acceptedBy\": null,\n" +
                "        \"author\": \"823463c7-6bb5-48b4-8718-6a661558ee73\",\n" +
                "        \"category\": \"427abf88-6918-4b44-8bf8-e104564168aa\",\n" +
                "        \"locations\": {\n" +
                "            \"type\": \"Point\",\n" +
                "            \"coordinates\": [\n" +
                "                49.264323,\n" +
                "                10.2336015\n" +
                "            ]\n" +
                "        },\n" +
                "        \"filters\": [\n" +
                "            {\n" +
                "                \"name\": \"weight\",\n" +
                "                \"value\": {\n" +
                "                    \"max\": 42000,\n" +
                "                    \"min\": 0\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"type\": \"MACHINE\",\n" +
                "        \"organization\": \"06a57ce9-58ce-4ae6-a00c-6f4086fddc83\",\n" +
                "        \"address\": \"E43, 91637 Wörnitz, Deutschland\",\n" +
                "        \"startDate\": \"2021-10-05T06:33:00.000Z\",\n" +
                "        \"endDate\": \"2021-10-19T22:00:00.000Z\",\n" +
                "        \"description\": null,\n" +
                "        \"prolongDates\": [],\n" +
                "        \"releaseDates\": [],\n" +
                "        \"isDummy\": false,\n" +
                "        \"hasDriver\": false,\n" +
                "        \"overwriteDate\": null,\n" +
                "        \"metaInfo\": null,\n" +
                "        \"warehouseId\": null,\n" +
                "        \"rentalDescription\": null,\n" +
                "        \"internalTransportations\": {\n" +
                "            \"id\": \"972df8e5-6b10-49c3-ba04-efbad6447ee3\",\n" +
                "            \"projectRequestId\": \"1cb040bd-f949-497d-8a54-ae3e8d90ee8c\",\n" +
                "            \"pickUpDate\": \"2021-10-04T07:00:00.000Z\",\n" +
                "            \"deliveryDate\": \"2021-10-05T07:00:00.000Z\",\n" +
                "            \"description\": null,\n" +
                "            \"status\": \"INITIAL\",\n" +
                "            \"startDateOption\": null,\n" +
                "            \"endDateOption\": null,\n" +
                "            \"pickUpLocation\": {\n" +
                "                \"type\": \"Point\",\n" +
                "                \"coordinates\": [\n" +
                "                    49.2453983,\n" +
                "                    10.2188083\n" +
                "                ]\n" +
                "            },\n" +
                "            \"deliveryLocation\": {\n" +
                "                \"type\": \"Point\",\n" +
                "                \"coordinates\": [\n" +
                "                    49.264323,\n" +
                "                    10.2336015\n" +
                "                ]\n" +
                "            },\n" +
                "            \"provider\": \"ffea47b2-13a9-4973-911e-bcdfbdedce6c\",\n" +
                "            \"pickUpLocationAddress\": \"Kurzmandl, 91637 Wörnitz, Germany\",\n" +
                "            \"deliveryLocationAddress\": \"E43, 91637 Wörnitz, Deutschland\",\n" +
                "            \"pGroup\": \"16b1f5b9-ff0e-4c43-bfd5-736f25d5d85f\",\n" +
                "            \"isOrganizedWithoutSam\": null,\n" +
                "            \"templatePGroup\": \"b4652b23-ab2b-45e9-9b47-c73df7bea466\",\n" +
                "            \"pickUpDateMilliseconds\": 1633330800000,\n" +
                "            \"deliveryDateMilliseconds\": 1633417200000,\n" +
                "            \"startDateOptionMilliseconds\": null,\n" +
                "            \"endDateOptionMilliseconds\": null\n" +
                "        },\n" +
                "        \"startDateMilliseconds\": 1633415580000,\n" +
                "        \"endDateMilliseconds\": 1634680800000,\n" +
                "        \"equipment\": {\n" +
                "            \"id\": \"c7d6e8a7-9ad8-4805-9c33-cf21a5c039a9\",\n" +
                "            \"title\": \"Bomag BW 100 Kombi AC-5 - Asphaltkolonne\",\n" +
                "            \"invNumber\": \"802.0006.719\",\n" +
                "            \"categoryId\": \"427abf88-6918-4b44-8bf8-e104564168aa\",\n" +
                "            \"modelId\": \"35c160a7-1a18-454b-a2bf-91f35f6c14af\",\n" +
                "            \"brandId\": \"54066fd0-3474-4b55-bb59-3610dd87b9a5\",\n" +
                "            \"year\": 2018,\n" +
                "            \"specifications\": [\n" +
                "                {\n" +
                "                    \"key\": \"drum_diameter\",\n" +
                "                    \"value\": \"0.7\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"key\": \"frequency\",\n" +
                "                    \"value\": \"67\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"key\": \"max_travel_speed\",\n" +
                "                    \"value\": \"10\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"key\": \"engine_power\",\n" +
                "                    \"value\": \"24600\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"key\": \"standard_compaction_width\",\n" +
                "                    \"value\": \"1.072\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"key\": \"fuel_type\",\n" +
                "                    \"value\": \"Diesel\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"key\": \"dimensions\",\n" +
                "                    \"value\": {\n" +
                "                        \"H\": \"2.529\",\n" +
                "                        \"L\": \"1\",\n" +
                "                        \"W\": \"1.808\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            \"weight\": 2400,\n" +
                "            \"additional_specifications\": null,\n" +
                "            \"structureId\": \"16b1f5b9-ff0e-4c43-bfd5-736f25d5d85f\",\n" +
                "            \"organizationId\": \"06a57ce9-58ce-4ae6-a00c-6f4086fddc83\",\n" +
                "            \"beaconType\": null,\n" +
                "            \"beaconId\": \"DE-2573459\",\n" +
                "            \"beaconVendor\": \"rosenberger\",\n" +
                "            \"RFID\": \"201910000000000000000217\",\n" +
                "            \"dailyPrice\": null,\n" +
                "            \"inactive\": null,\n" +
                "            \"tag\": {\n" +
                "                \"date\": \"2019-12-01\",\n" +
                "                \"authorName\": \"\",\n" +
                "                \"media\": []\n" +
                "            },\n" +
                "            \"telematicBox\": null,\n" +
                "            \"createdAt\": \"2018-02-24T00:00:00.000Z\",\n" +
                "            \"special_number\": null,\n" +
                "            \"last_check\": \"1970-01-01\",\n" +
                "            \"next_check\": \"1970-01-01\",\n" +
                "            \"responsible_person\": null,\n" +
                "            \"test_type\": null,\n" +
                "            \"unique_equipment_id\": \"DE-2573459\",\n" +
                "            \"bgl_number\": \"D832 0240\",\n" +
                "            \"serial_number\": null,\n" +
                "            \"inventory\": null,\n" +
                "            \"warehouseId\": \"58f84c39-8883-46fb-ba9a-70fd2b1d1e0e\",\n" +
                "            \"trackingTag\": null,\n" +
                "            \"workingHours\": null,\n" +
                "            \"navaris_criteria\": null,\n" +
                "            \"dont_send_to_as400\": true,\n" +
                "            \"model\": {\n" +
                "                \"id\": \"35c160a7-1a18-454b-a2bf-91f35f6c14af\",\n" +
                "                \"name\": \"BW 100 AC-5\",\n" +
                "                \"createdAt\": \"2021-09-16T01:13:20.000Z\",\n" +
                "                \"brand\": {\n" +
                "                    \"id\": \"54066fd0-3474-4b55-bb59-3610dd87b9a5\",\n" +
                "                    \"name\": \"Bomag\",\n" +
                "                    \"createdAt\": \"2021-09-16T01:08:19.000Z\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"brand\": {\n" +
                "                \"id\": \"54066fd0-3474-4b55-bb59-3610dd87b9a5\",\n" +
                "                \"name\": \"Bomag\",\n" +
                "                \"createdAt\": \"2021-09-16T01:08:19.000Z\"\n" +
                "            },\n" +
                "            \"category\": {\n" +
                "                \"id\": \"427abf88-6918-4b44-8bf8-e104564168aa\",\n" +
                "                \"name\": \"Combi rollers\",\n" +
                "                \"name_de\": \"Kombiwalzen\",\n" +
                "                \"createdAt\": \"2021-09-16T01:03:46.766Z\",\n" +
                "                \"media\": []\n" +
                "            },\n" +
                "            \"structure\": {\n" +
                "                \"id\": \"16b1f5b9-ff0e-4c43-bfd5-736f25d5d85f\",\n" +
                "                \"name\": \"Gruppe Augsburg\",\n" +
                "                \"type\": \"group\",\n" +
                "                \"color\": \"#FF0000\"\n" +
                "            },\n" +
                "            \"wareHouse\": null,\n" +
                "            \"equipmentMedia\": [\n" +
                "                {\n" +
                "                    \"id\": \"5c38745a-98af-4ac0-a118-d9c7101f95b1\",\n" +
                "                    \"name\": \"c7d6e8a7-9ad8-4805-9c33-cf21a5c039a9.jpg\",\n" +
                "                    \"files\": [\n" +
                "                        {\n" +
                "                            \"size\": \"original\",\n" +
                "                            \"path\": \"https://cf.sam.strabag.io/media%2Fc7d6e8a7-9ad8-4805-9c33-cf21a5c039a9%2FBOMAG%20BW100.jpg\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"size\": \"190x190\",\n" +
                "                            \"path\": \"https://cf.sam.strabag.io/media%2Fc7d6e8a7-9ad8-4805-9c33-cf21a5c039a9%2F190x190-BOMAG%20BW100.jpg\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"type\": \"image/jpeg\",\n" +
                "                    \"modelId\": \"c7d6e8a7-9ad8-4805-9c33-cf21a5c039a9\",\n" +
                "                    \"main\": true,\n" +
                "                    \"modelType\": \"eq-img\",\n" +
                "                    \"createdAt\": \"2021-08-17T11:27:20.840Z\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4d901e16-38a7-4ca7-9092-3cde14b37e21\",\n" +
                "                    \"name\": \"c7d6e8a7-9ad8-4805-9c33-cf21a5c039a9.jpg\",\n" +
                "                    \"files\": [\n" +
                "                        {\n" +
                "                            \"size\": \"original\",\n" +
                "                            \"path\": \"https://cf.sam.strabag.io/media%2Fc7d6e8a7-9ad8-4805-9c33-cf21a5c039a9%2FBOMAG%20BW100%20Inv.jpg\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"size\": \"190x190\",\n" +
                "                            \"path\": \"https://cf.sam.strabag.io/media%2Fc7d6e8a7-9ad8-4805-9c33-cf21a5c039a9%2F190x190-BOMAG%20BW100%20Inv.jpg\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"type\": \"image/jpeg\",\n" +
                "                    \"modelId\": \"c7d6e8a7-9ad8-4805-9c33-cf21a5c039a9\",\n" +
                "                    \"main\": false,\n" +
                "                    \"modelType\": \"eq-img\",\n" +
                "                    \"createdAt\": \"2021-08-17T11:27:20.840Z\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"69c46ade-7717-49f2-bbed-793458ab569b\",\n" +
                "                    \"name\": \"c7d6e8a7-9ad8-4805-9c33-cf21a5c039a9.jpg\",\n" +
                "                    \"files\": [\n" +
                "                        {\n" +
                "                            \"size\": \"original\",\n" +
                "                            \"path\": \"https://cf.sam.strabag.io/media%2Fc7d6e8a7-9ad8-4805-9c33-cf21a5c039a9%2FIMG_2200.JPG\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"size\": \"190x190\",\n" +
                "                            \"path\": \"https://cf.sam.strabag.io/media%2Fc7d6e8a7-9ad8-4805-9c33-cf21a5c039a9%2F190x190-IMG_2200.JPG\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"type\": \"image/jpeg\",\n" +
                "                    \"modelId\": \"c7d6e8a7-9ad8-4805-9c33-cf21a5c039a9\",\n" +
                "                    \"main\": false,\n" +
                "                    \"modelType\": \"eq-img\",\n" +
                "                    \"createdAt\": \"2021-08-17T11:27:20.840Z\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"telematics\": [\n" +
                "                {\n" +
                "                    \"timestamp\": 1634018418000,\n" +
                "                    \"eventType\": \"CHECKIN\",\n" +
                "                    \"projectId\": \"1032a888-53e2-4f5d-8661-8ae2581de69b\",\n" +
                "                    \"equipmentId\": \"c7d6e8a7-9ad8-4805-9c33-cf21a5c039a9\",\n" +
                "                    \"locationName\": \"GGZA - Maschinistentage 2020\",\n" +
                "                    \"location\": {\n" +
                "                        \"type\": \"MultiPolygon\",\n" +
                "                        \"coordinates\": [\n" +
                "                            [\n" +
                "                                [\n" +
                "                                    [\n" +
                "                                        10.330895,\n" +
                "                                        48.032767\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        10.332609,\n" +
                "                                        48.032989\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        10.332796,\n" +
                "                                        48.03088\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        10.331622,\n" +
                "                                        48.0306\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        10.331675,\n" +
                "                                        48.029334\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        10.329068,\n" +
                "                                        48.029058\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        10.328827,\n" +
                "                                        48.031458\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        10.330865,\n" +
                "                                        48.032093\n" +
                "                                    ],\n" +
                "                                    [\n" +
                "                                        10.330895,\n" +
                "                                        48.032767\n" +
                "                                    ]\n" +
                "                                ]\n" +
                "                            ]\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    \"costCenter\": \"XX RC-KST-DE-802-GGZA\",\n" +
                "                    \"lastLatitude\": 48.029462,\n" +
                "                    \"lastLongitude\": 10.329196,\n" +
                "                    \"lastLatLonPrecise\": true,\n" +
                "                    \"lastAddressByLatLon\": \"28HH+QM Erkheim, Germany\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"isMoving\": false\n" +
                "        }\n" +
                "    }"
    )

    // checking id for correctness and setting it to textview in fragment
    fun parseJson(): String {
        val request = Gson().fromJson(jsonObject.toString(), Data::class.java)
        val id = request.id.toString()
        return id
    }
}
