package com.au.tugasuserinput

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import java.lang.reflect.Modifier

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
    ) {


    }

}