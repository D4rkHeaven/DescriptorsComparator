package descriptors;

import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.BRISK;
import org.opencv.features2d.Features2d;

public class Brief {
    /**
     * Реализация дескриптора BRIEF
     *
     * @param input входное изображение
     * @return обработанное изображение
     */
    public Mat run(Mat input) {
        long time = System.currentTimeMillis();
        int hessianThreshold = 400;
        int nOctaves = 4, nOctaveLayers = 3;
        MatOfKeyPoint keypoints = new MatOfKeyPoint();
        Mat descriptor = new Mat();
        Mat output = new Mat();
        BRISK brisk = BRISK.create(hessianThreshold, nOctaves, nOctaveLayers);
        brisk.detectAndCompute(input, new Mat(), keypoints, descriptor);
        Features2d.drawKeypoints(input, keypoints, output);
        time = System.currentTimeMillis() - time;
        System.out.println("Processing time in ms = " + time);
        System.out.println("Number of keypoints = " + keypoints.toList().toArray().length);
        return output;
    }
}
