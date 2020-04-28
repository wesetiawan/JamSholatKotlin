package com.ws.jamsholat.util

import android.content.Context
import android.location.LocationManager


class Util{

    companion object{
        fun getCurrentTime():Long{
            val tsLong = System.currentTimeMillis();
            return tsLong
        }

        fun getCurrentLatitude():String{
            return "-7.795580"
        }
        fun getCurrentLongitude():String{
            return "110.369492"
        }
    }


}
