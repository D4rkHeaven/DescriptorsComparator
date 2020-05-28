package descriptors;

import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.Features2d;
import org.opencv.features2d.ORB;

import java.util.ArrayList;
import java.util.List;

public class Orb {
    /**
     * Реализация дескриптора ORB
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
        ORB orb = ORB.create(hessianThreshold, nOctaves, nOctaveLayers);
        orb.detectAndCompute(input, new Mat(), keypoints, descriptor);
        Features2d.drawKeypoints(input, keypoints, output);
        time = System.currentTimeMillis() - time;
        System.out.println("Processing time in ms = " + time);
        System.out.println("Number of keypoints = " + keypoints.toList().toArray().length);
        return output;
    }
}
