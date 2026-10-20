package com.example.boutique

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import io.github.sceneview.SceneView
import io.github.sceneview.node.ModelNode
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberModelInstance

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val engine = rememberEngine()
            val modelLoader = rememberModelLoader(engine)
            val modelInstance = rememberModelInstance(
                modelLoader = modelLoader,
                assetFileLocation = "male_body_walk.glb"
            )

            SceneView(
                modifier = Modifier.fillMaxSize(),
                engine = engine,
                modelLoader = modelLoader
            ) {
                modelInstance?.let { instance ->
                    ModelNode(
                        modelInstance = instance,
                        scaleToUnits = 1.6f,
                        autoAnimate = true,
                        animationName = "Walk_Loop",
                        animationLoop = true,
                        animationSpeed = 1.0f
                    )
                }
            }
        }
    }
}
