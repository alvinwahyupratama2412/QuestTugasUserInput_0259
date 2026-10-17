package com.au.tugasuserinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun  FormBiodata(modifier: Modifier){

    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var android by remember { mutableStateOf("") }
    var uix by remember { mutableStateOf("") }
    var web by remember { mutableStateOf("") }
    var dropdownterbuka by remember { mutableStateOf("") }
    var tanggalDialog by remember { mutableStateOf("") }
    var berhasil by remember { mutableStateOf("") }
    var datePickerState by remember { mutableStateOf("") }
    var dateFormat by remember { mutableStateOf("") }
    val daftarpengalaman = listOf(
        stringResource(R.string.experience_beginer),
        stringResource(R.string.experience_intermediate),
        stringResource(R.string.experience_advanced)
    )
    Scaffold(
        modifier= modifier.fillMaxSize(),
        containerColor = colorResource(R.color.white)
    ) { innerPadding ->
        Box(
            modifier= Modifier.fillMaxSize()
                .padding(innerPadding)
                .background(colorResource(R.color.white))
        ){
            Image(
                painter = painterResource(
                    R.drawable.background
                ),
                contentDescription = stringResource(R.string.background_description),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
                    .height(
                        dimensionResource(R.dimen.header_height)
                    )
                    .align(Alignment.TopCenter)
            )
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = dimensionResource(R.dimen.card_offset)
                    ),
                shape = RoundedCornerShape(
                    topStart = dimensionResource(R.dimen.card_radius),
                    topEnd =  dimensionResource(R.dimen.card_radius)
                ),
                color = colorResource(R.color.white),
                shadowElevation = dimensionResource(R.dimen.card_elevation)
            ) { }
        }


    }

}