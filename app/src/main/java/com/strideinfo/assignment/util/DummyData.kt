package com.strideinfo.assignment.util

import com.strideinfo.assignment.R

object DummyData  {
     val category = arrayListOf<Int>(
        R.drawable.ic_aerobics_,
        R.drawable.ic_children_selection,
        R.drawable.ic_dances,
        R.drawable.ic_gym,
        R.drawable.ic_run,
        R.drawable.ic_swimming,
        R.drawable.ic_wrestling
    )
    const val TEST_JSON="{\n" +
            "  \"gyms\": [\n" +
            "    {\n" +
            "      \"id\": 1,\n" +
            "      \"title\": \"Gym Rebel\",\n" +
            "      \"rating\": 5.5,\n" +
            "      \"price\": 250,\n" +
            "      \"favorite\": false,\n" +
            "      \"date\": \"02 Aug - 25 Aug, 2020\",\n" +
            "      \"popular_clasess\": [\n" +
            "        { \n" +
            "           \"title\": \"Fitness Class\", \n" +
            "           \"price\": 350,\n" +
            "           \"favorite\": false, \n" +
            "           \"location\": \"London, Spring st. 8\",\n" +
            "           \"time\": \"1h 25min\"\n" +
            "        }, {  \n" +
            "           \"title\": \"Fitness with some friends\", \n" +
            "           \"price\": 250,\n" +
            "           \"favorite\": false, \n" +
            "           \"location\": \"London, Spring st. 8\",\n" +
            "           \"time\": \"45min\"\n" +
            "        }, {  \n" +
            "           \"title\": \"Yoga Class\", \n" +
            "           \"price\": 150,\n" +
            "           \"favorite\": false, \n" +
            "           \"location\": \"London, Wellness st. 23\",\n" +
            "           \"time\": \"25min\"\n" +
            "        }, {  \n" +
            "           \"title\": \"Crossfit Class\", \n" +
            "           \"price\": 200,\n" +
            "           \"favorite\": false, \n" +
            "           \"location\": \"London,Villers st. 1\",\n" +
            "           \"time\": \"1h 30min\"\n" +
            "        }\n" +
            "      ] \n" +
            "    }, {\n" +
            "      \"id\": 2,\n" +
            "      \"title\": \"Gym NonStop\",\n" +
            "      \"rating\": 3.5,\n" +
            "      \"price\": 500,\n" +
            "      \"favorite\": false,\n" +
            "      \"date\": \"01 Aug - 30 Aug, 2020\",\n" +
            "      \"popular_clasess\": [\n" +
            "        { \n" +
            "           \"title\": \"Fitness Class\", \n" +
            "           \"price\": 350,\n" +
            "           \"favorite\": false, \n" +
            "           \"location\": \"London, Spring st. 8\",\n" +
            "           \"time\": \"1h 25min\"\n" +
            "        }, {  \n" +
            "           \"title\": \"Fitness with some friends\", \n" +
            "           \"price\": 250,\n" +
            "           \"favorite\": false, \n" +
            "           \"location\": \"London, Spring st. 8\",\n" +
            "           \"time\": \"45min\"\n" +
            "        }, {  \n" +
            "           \"title\": \"Yoga Class\", \n" +
            "           \"price\": 150,\n" +
            "           \"favorite\": false, \n" +
            "           \"location\": \"London, Wellness st. 23\",\n" +
            "           \"time\": \"25min\"\n" +
            "        }\n" +
            "      ] \n" +
            "    }, {\n" +
            "      \"id\": 3,\n" +
            "      \"title\": \"Gym Gym\",\n" +
            "      \"rating\": 1.5,\n" +
            "      \"price\": 150,\n" +
            "      \"favorite\": false,\n" +
            "      \"date\": \"05 Aug - 16 Aug, 2020\",\n" +
            "      \"popular_clasess\": [ ] \n" +
            "    }\n" +
            "  ]\n" +
            "}"
}