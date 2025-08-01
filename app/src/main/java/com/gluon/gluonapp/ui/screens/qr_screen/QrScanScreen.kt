package com.gluon.gluonapp.ui.screens.qr_screen

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat

import androidx.navigation.NavController
import com.gluon.gluonapp.R
import com.gluon.gluonapp.navigation.QrDetailScreen
import com.gluon.gluonapp.navigation.QrSearchScreen
import com.gluon.gluonapp.ui.components.AppScaffold
import com.gluon.gluonapp.ui.components.buttonIcon.BackNavigationIcon
import com.gluon.gluonapp.ui.components.qr.QRScannerOverlay
import com.gluon.gluonapp.ui.components.qr.QRScannerView
import com.gluon.gluonapp.ui.theme.GreyColor



@Composable
fun QrScanScreen(
    navController: NavController,

) {
    var result by remember { mutableStateOf<String?>(null) }
    var isFlashOn by remember { mutableStateOf(false) }
    var zoomLevel by remember { mutableStateOf(1f) }
    val minZoom = 1f
    val maxZoom = 5f
    val context = LocalContext.current
    val permissionState = remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        permissionState.value = isGranted
    }

    LaunchedEffect(Unit) {
        if (!permissionState.value) {
            launcher.launch(Manifest.permission.CAMERA)
        }
    }



    AppScaffold(navController) {
        Box(
            modifier = Modifier
                .fillMaxSize()

        ) {


            QRScannerView(
                isFlashOn = isFlashOn,
                zoom = zoomLevel,
                onQrCodeScanned = { scannedCode -> result = scannedCode }
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                    .align(Alignment.TopCenter),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BackNavigationIcon(navController, modifier = Modifier)



                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_picture),
                        contentDescription = "Picture",
                        tint = White
                    )
                }
            }


            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                QRScannerOverlay()

                Spacer(modifier = Modifier.height(72.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {
                            zoomLevel = (zoomLevel - 0.5f).coerceAtLeast(minZoom)
                        }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_zoom_out),
                            contentDescription = "Zoom Out",
                            tint = White
                        )
                    }

                    Slider(
                        value = zoomLevel,
                        onValueChange = { zoomLevel = it },
                        valueRange = minZoom..maxZoom,
                        steps = ((maxZoom - minZoom) / 0.5f).toInt() - 1,
                        modifier = Modifier.width(150.dp),
                        colors = SliderDefaults.colors(
                            thumbColor = Green,
                            activeTrackColor = White,
                            inactiveTrackColor = GreyColor
                        )
                    )

                    IconButton(
                        onClick = {
                            zoomLevel = (zoomLevel + 0.5f).coerceAtMost(maxZoom)
                        }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_zoom_in),
                            contentDescription = "Zoom In",
                            tint = White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(72.dp))

                Row(
                    modifier = Modifier.width(202.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    IconButton(onClick = { navController.navigate(QrSearchScreen) }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_qr_edit),
                            contentDescription = "Edit QR",
                            tint = White
                        )
                    }




                    IconButton(onClick = { isFlashOn = !isFlashOn }) {
                        val flashIcon = if (isFlashOn)
                            ImageVector.vectorResource(R.drawable.ic_flash_on)
                        else
                            ImageVector.vectorResource(R.drawable.ic_flash_off)

                        Icon(
                            imageVector = flashIcon,
                            contentDescription = "Toggle Flash",
                            tint = White
                        )
                    }
                }
            }


            result?.let {
                LaunchedEffect(Unit) {
                    navController.navigate(QrDetailScreen)
                }
            }
        }
    }

}