package com.example.boutique

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.sceneview.SceneView
import io.github.sceneview.math.Position
import io.github.sceneview.node.ModelNode

class MainActivity : AppCompatActivity() {

    private lateinit var sceneView: SceneView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sceneView = findViewById(R.id.sceneView)

        val instance = sceneView.modelLoader.createModelInstance(
            assetFileLocation = "posed_mannequin.glb"
        )

        val node = ModelNode(
            modelInstance = instance,
            scaleToUnits = 1.6f,
            centerOrigin = Position(0.0f)
        )
        sceneView.addChildNode(node)
    }

    override fun onDestroy() {
        sceneView.destroy()
        super.onDestroy()
    }
}
