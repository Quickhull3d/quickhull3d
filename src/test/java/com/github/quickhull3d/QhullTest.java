package com.github.quickhull3d;

import com.github.quickhull3d.QuickHull3D;

/*
 * #%L
 * A Robust 3D Convex Hull Algorithm in Java
 * %%
 * Copyright (C) 2004 - 2014 John E. Lloyd
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

class QhullTest {

    static double[] coords = new double[]{};

    static int[][] faces = new int[][]{};

    public static void main(String[] args) {
        QuickHull3D hull = new QuickHull3D();
        QuickHull3DTest tester = new QuickHull3DTest();

        hull = new QuickHull3D();

        for (int i = 0; i < 100; i++) {
            double[] pnts = tester.randomCubedPoints(100, 1.0, 0.5);

            hull.setFromQhull(pnts, pnts.length / 3, /* triangulated= */false);

            pnts = tester.addDegeneracy(QuickHull3DTest.VERTEX_DEGENERACY, pnts, hull);

            // hull = new QuickHull3D ();
            hull.setFromQhull(pnts, pnts.length / 3, /* triangulated= */true);

            if (!hull.check(System.out)) {
                System.out.println("failed for qhull triangulated");
            }

            // hull = new QuickHull3D ();
            hull.setFromQhull(pnts, pnts.length / 3, /* triangulated= */false);

            if (!hull.check(System.out)) {
                System.out.println("failed for qhull regular");
            }

            // hull = new QuickHull3D ();
            hull.build(pnts, pnts.length / 3);
            hull.triangulate();

            if (!hull.check(System.out)) {
                System.out.println("failed for QuickHull3D triangulated");
            }

            // hull = new QuickHull3D ();
            hull.build(pnts, pnts.length / 3);

            if (!hull.check(System.out)) {
                System.out.println("failed for QuickHull3D regular");
            }
        }
    }
}
