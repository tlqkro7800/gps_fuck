import android.os.Bundle
import android.os.CountDownTimer
import android.view.TextureView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import com.example.gps_final.R
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class CameraActivity : AppCompatActivity() {
    private var cameraExecutor: ExecutorService = Executors.newSingleThreadExecutor()

    private lateinit var timerTextView: TextView
    private var studyTimeInSeconds = 0
    private var points = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        startCamera()


        val timerTextView = findViewById<TextView>(R.id.timer)

        val pointIncrementTimer = object : CountDownTimer(Long.MAX_VALUE, 60000) {
            override fun onTick(millisUntilFinished: Long) {
                points++
            }

            override fun onFinish() {
                // 아무것도 하지 않음
            }
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener({
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
            var viewFinder = findViewById<TextureView>(R.id.viewFinder)

            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(viewFinder)
                }

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview)
            } catch (exc: Exception) {
                // Handle any errors
            }
        }, ContextCompat.getMainExecutor(this))
    }


    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }
}