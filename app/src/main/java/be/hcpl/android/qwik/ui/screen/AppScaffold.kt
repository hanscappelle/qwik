package be.hcpl.android.qwik.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.ui.theme.AppTheme
import be.hcpl.android.qwik.ui.theme.customColor2
import be.hcpl.android.qwik.ui.theme.onPrimaryDark

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun AppScaffold(
    title: String = stringResource(R.string.title_app),
    onBack: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    AppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = title) },
                    colors =
                    TopAppBarDefaults.topAppBarColors(
                        containerColor = customColor2,
                        titleContentColor = onPrimaryDark,
                        navigationIconContentColor = onPrimaryDark,
                        actionIconContentColor = onPrimaryDark,
                    ),
                    navigationIcon = {
                        onBack?.let {
                            IconButton(onClick = { onBack() }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = stringResource(R.string.description_navigate_back)
                                )
                            }
                        }
                    }
                )
            }) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
            ) {
                content()
            }
        }
    }
}

@Preview
@Composable
fun AppScaffoldPreview() {
    AppScaffold { }
}