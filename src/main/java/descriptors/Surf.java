package descriptors;

import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.Features2d;
import org.opencv.features2d.ORB;

public class Surf {
    /**
     * Реализация дескриптора SURF
     *
     * @param input входное изображение
     * @return обработанное изображение
     */
    public Mat run(Mat input) {
        int hessianThreshold = 400;
        int nOctaves = 4, nOctaveLayers = 3;
        MatOfKeyPoint keypoints = new MatOfKeyPoint();
        Mat descriptor = new Mat();
        Mat output = new Mat();
        ORB orb = ORB.create(hessianThreshold, nOctaves, nOctaveLayers);
        orb.detectAndCompute(input, new Mat(), keypoints, descriptor);
        Features2d.drawKeypoints(input, keypoints, output);
        return output;
    }
}
