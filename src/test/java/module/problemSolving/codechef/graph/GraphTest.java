package module.problemSolving.codechef.graph;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;

import java.io.*;

/**
 * @author rumman
 * @since 12/18/18
 */
public class GraphTest {

    @Test
    public void testSumOfDigits() {
        svgToImage();
    }

    public static void svgToImage() {
        //Step -1: We read the input SVG document into Transcoder Input
        //We use Java NIO for this purpose
//        String svg_URI_input = Paths.get("chessboard.svg").toUri().toURL().toString();
        String imageString = "<svg\n" +
                "\txmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" class=\"highcharts-root\" style=\"font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Arial, Helvetica, sans-serif;font-size:12px;\"\n" +
                "\txmlns=\"http://www.w3.org/2000/svg\" width=\"600\" height=\"400\" viewBox=\"0 0 600 400\">\n" +
                "\t<desc>Created with Highcharts 7.0.3</desc>\n" +
                "\t<defs>\n" +
                "\t\t<clipPath id=\"highcharts-73hgae7-48\">\n" +
                "\t\t\t<rect x=\"0\" y=\"0\" width=\"348\" height=\"306\" fill=\"none\"></rect>\n" +
                "\t\t</clipPath>\n" +
                "\t</defs>\n" +
                "\t<rect fill=\"#ffffff\" class=\"highcharts-background\" x=\"0\" y=\"0\" width=\"600\" height=\"400\" rx=\"0\" ry=\"0\"></rect>\n" +
                "\t<rect fill=\"none\" class=\"highcharts-plot-background\" x=\"73\" y=\"59\" width=\"348\" height=\"306\"></rect>\n" +
                "\t<g class=\"highcharts-grid highcharts-xaxis-grid \" data-z-index=\"1\">\n" +
                "\t\t<path fill=\"none\" data-z-index=\"1\" class=\"highcharts-grid-line\" d=\"M 75.5 59 L 75.5 365\" opacity=\"1\"></path>\n" +
                "\t\t<path fill=\"none\" data-z-index=\"1\" class=\"highcharts-grid-line\" d=\"M 173.5 59 L 173.5 365\" opacity=\"1\"></path>\n" +
                "\t\t<path fill=\"none\" data-z-index=\"1\" class=\"highcharts-grid-line\" d=\"M 270.5 59 L 270.5 365\" opacity=\"1\"></path>\n" +
                "\t\t<path fill=\"none\" data-z-index=\"1\" class=\"highcharts-grid-line\" d=\"M 368.5 59 L 368.5 365\" opacity=\"1\"></path>\n" +
                "\t</g>\n" +
                "\t<g class=\"highcharts-grid highcharts-yaxis-grid \" data-z-index=\"1\">\n" +
                "\t\t<path fill=\"none\" stroke=\"#e6e6e6\" stroke-width=\"1\" data-z-index=\"1\" class=\"highcharts-grid-line\" d=\"M 73 365.5 L 421 365.5\" opacity=\"1\"></path>\n" +
                "\t\t<path fill=\"none\" stroke=\"#e6e6e6\" stroke-width=\"1\" data-z-index=\"1\" class=\"highcharts-grid-line\" d=\"M 73 289.5 L 421 289.5\" opacity=\"1\"></path>\n" +
                "\t\t<path fill=\"none\" stroke=\"#e6e6e6\" stroke-width=\"1\" data-z-index=\"1\" class=\"highcharts-grid-line\" d=\"M 73 212.5 L 421 212.5\" opacity=\"1\"></path>\n" +
                "\t\t<path fill=\"none\" stroke=\"#e6e6e6\" stroke-width=\"1\" data-z-index=\"1\" class=\"highcharts-grid-line\" d=\"M 73 136.5 L 421 136.5\" opacity=\"1\"></path>\n" +
                "\t\t<path fill=\"none\" stroke=\"#e6e6e6\" stroke-width=\"1\" data-z-index=\"1\" class=\"highcharts-grid-line\" d=\"M 73 58.5 L 421 58.5\" opacity=\"1\"></path>\n" +
                "\t</g>\n" +
                "\t<rect fill=\"none\" class=\"highcharts-plot-border\" data-z-index=\"1\" x=\"73\" y=\"59\" width=\"348\" height=\"306\"></rect>\n" +
                "\t<g class=\"highcharts-axis highcharts-xaxis \" data-z-index=\"2\">\n" +
                "\t\t<path fill=\"none\" class=\"highcharts-tick\" stroke=\"#ccd6eb\" stroke-width=\"1\" d=\"M 75.5 365 L 75.5 375\" opacity=\"1\"></path>\n" +
                "\t\t<path fill=\"none\" class=\"highcharts-tick\" stroke=\"#ccd6eb\" stroke-width=\"1\" d=\"M 173.5 365 L 173.5 375\" opacity=\"1\"></path>\n" +
                "\t\t<path fill=\"none\" class=\"highcharts-tick\" stroke=\"#ccd6eb\" stroke-width=\"1\" d=\"M 270.5 365 L 270.5 375\" opacity=\"1\"></path>\n" +
                "\t\t<path fill=\"none\" class=\"highcharts-tick\" stroke=\"#ccd6eb\" stroke-width=\"1\" d=\"M 368.5 365 L 368.5 375\" opacity=\"1\"></path>\n" +
                "\t\t<path fill=\"none\" class=\"highcharts-axis-line\" stroke=\"#ccd6eb\" stroke-width=\"1\" data-z-index=\"7\" d=\"M 73 365.5 L 421 365.5\"></path>\n" +
                "\t</g>\n" +
                "\t<g class=\"highcharts-axis highcharts-yaxis \" data-z-index=\"2\">\n" +
                "\t\t<text x=\"24\" data-z-index=\"7\" text-anchor=\"middle\" transform=\"translate(0,0) rotate(270 24 212)\" class=\"highcharts-axis-title\" style=\"color:#666666;fill:#666666;\" y=\"212\">\n" +
                "\t\t\t<tspan>Number of Employees</tspan>\n" +
                "\t\t</text>\n" +
                "\t\t<path fill=\"none\" class=\"highcharts-axis-line\" data-z-index=\"7\" d=\"M 73 59 L 73 365\"></path>\n" +
                "\t</g>\n" +
                "\t<g class=\"highcharts-series-group\" data-z-index=\"3\">\n" +
                "\t\t<g data-z-index=\"0.1\" class=\"highcharts-series highcharts-series-0 highcharts-line-series highcharts-color-0 \" transform=\"translate(73,59) scale(1 1)\" clip-path=\"url(#highcharts-73hgae7-48)\">\n" +
                "\t\t\t<path fill=\"none\" d=\"M 3.4117647058793 238.78098 L 52.1512605042 225.67041 L 100.89075630252 218.51919 L 149.63025210084 199.42326000000003 L 198.36974789916 157.54257 L 247.10924369748 122.50557 L 295.8487394958 96.18651000000003 L 344.58823529412 70.11225000000002\" class=\"highcharts-graph\" data-z-index=\"1\" stroke=\"#7cb5ec\" stroke-width=\"2\" stroke-linejoin=\"round\" stroke-linecap=\"round\"></path>\n" +
                "\t\t</g>\n" +
                "\t\t<g data-z-index=\"0.1\" class=\"highcharts-markers highcharts-series-0 highcharts-line-series highcharts-color-0 \" transform=\"translate(73,59) scale(1 1)\" clip-path=\"none\">\n" +
                "\t\t\t<path fill=\"#7cb5ec\" d=\"M 7 239 A 4 4 0 1 1 6.999998000000167 238.99600000066667 Z\" class=\"highcharts-point highcharts-color-0\"></path>\n" +
                "\t\t\t<path fill=\"#7cb5ec\" d=\"M 56 226 A 4 4 0 1 1 55.99999800000017 225.99600000066667 Z\" class=\"highcharts-point highcharts-color-0\"></path>\n" +
                "\t\t\t<path fill=\"#7cb5ec\" d=\"M 104 219 A 4 4 0 1 1 103.99999800000016 218.99600000066667 Z\" class=\"highcharts-point highcharts-color-0\"></path>\n" +
                "\t\t\t<path fill=\"#7cb5ec\" d=\"M 153 199 A 4 4 0 1 1 152.99999800000018 198.99600000066667 Z\" class=\"highcharts-point highcharts-color-0\"></path>\n" +
                "\t\t\t<path fill=\"#7cb5ec\" d=\"M 202 158 A 4 4 0 1 1 201.99999800000018 157.99600000066667 Z\" class=\"highcharts-point highcharts-color-0\"></path>\n" +
                "\t\t\t<path fill=\"#7cb5ec\" d=\"M 251 123 A 4 4 0 1 1 250.99999800000018 122.99600000066667 Z\" class=\"highcharts-point highcharts-color-0\"></path>\n" +
                "\t\t\t<path fill=\"#7cb5ec\" d=\"M 299 96 A 4 4 0 1 1 298.9999980000002 95.99600000066667 Z\" class=\"highcharts-point highcharts-color-0\"></path>\n" +
                "\t\t\t<path fill=\"#7cb5ec\" d=\"M 348 70 A 4 4 0 1 1 347.9999980000002 69.99600000066667 Z\" class=\"highcharts-point highcharts-color-0\"></path>\n" +
                "\t\t</g>\n" +
                "\t\t<g data-z-index=\"0.1\" class=\"highcharts-series highcharts-series-1 highcharts-line-series highcharts-color-1 \" transform=\"translate(73,59) scale(1 1)\" clip-path=\"url(#highcharts-73hgae7-48)\">\n" +
                "\t\t\t<path fill=\"none\" d=\"M 3.4117647058793 267.87852 L 52.1512605042 269.18208 L 100.89075630252 260.49474 L 149.63025210084 260.32797 L 198.36974789916 256.2903 L 247.10924369748 259.66854 L 295.8487394958 247.67487 L 344.58823529412 244.13598000000002\" class=\"highcharts-graph\" data-z-index=\"1\" stroke=\"#434348\" stroke-width=\"2\" stroke-linejoin=\"round\" stroke-linecap=\"round\"></path>\n" +
                "\t\t</g>\n" +
                "\t\t<g data-z-index=\"0.1\" class=\"highcharts-markers highcharts-series-1 highcharts-line-series highcharts-color-1 \" transform=\"translate(73,59) scale(1 1)\" clip-path=\"none\">\n" +
                "\t\t\t<path fill=\"#434348\" d=\"M 3 264 L 7 268 3 272 -1 268 Z\" class=\"highcharts-point highcharts-color-1\"></path>\n" +
                "\t\t\t<path fill=\"#434348\" d=\"M 52 265 L 56 269 52 273 48 269 Z\" class=\"highcharts-point highcharts-color-1\"></path>\n" +
                "\t\t\t<path fill=\"#434348\" d=\"M 100 256 L 104 260 100 264 96 260 Z\" class=\"highcharts-point highcharts-color-1\"></path>\n" +
                "\t\t\t<path fill=\"#434348\" d=\"M 149 256 L 153 260 149 264 145 260 Z\" class=\"highcharts-point highcharts-color-1\"></path>\n" +
                "\t\t\t<path fill=\"#434348\" d=\"M 198 252 L 202 256 198 260 194 256 Z\" class=\"highcharts-point highcharts-color-1\"></path>\n" +
                "\t\t\t<path fill=\"#434348\" d=\"M 247 256 L 251 260 247 264 243 260 Z\" class=\"highcharts-point highcharts-color-1\"></path>\n" +
                "\t\t\t<path fill=\"#434348\" d=\"M 295 244 L 299 248 295 252 291 248 Z\" class=\"highcharts-point highcharts-color-1\"></path>\n" +
                "\t\t\t<path fill=\"#434348\" d=\"M 344 240 L 348 244 344 248 340 244 Z\" class=\"highcharts-point highcharts-color-1\"></path>\n" +
                "\t\t</g>\n" +
                "\t\t<g data-z-index=\"0.1\" class=\"highcharts-series highcharts-series-2 highcharts-line-series highcharts-color-2 \" transform=\"translate(73,59) scale(1 1)\" clip-path=\"url(#highcharts-73hgae7-48)\">\n" +
                "\t\t\t<path fill=\"none\" d=\"M 3.4117647058793 288.03168 L 52.1512605042 278.88534 L 100.89075630252 281.51235 L 149.63025210084 275.75037 L 198.36974789916 275.11695 L 247.10924369748 268.70319 L 295.8487394958 256.81509 L 344.58823529412 245.73789\" class=\"highcharts-graph\" data-z-index=\"1\" stroke=\"#90ed7d\" stroke-width=\"2\" stroke-linejoin=\"round\" stroke-linecap=\"round\"></path>\n" +
                "\t\t</g>\n" +
                "\t\t<g data-z-index=\"0.1\" class=\"highcharts-markers highcharts-series-2 highcharts-line-series highcharts-color-2 \" transform=\"translate(73,59) scale(1 1)\" clip-path=\"none\">\n" +
                "\t\t\t<path fill=\"#90ed7d\" d=\"M -1 284 L 7 284 7 292 -1 292 Z\" class=\"highcharts-point highcharts-color-2\"></path>\n" +
                "\t\t\t<path fill=\"#90ed7d\" d=\"M 48 275 L 56 275 56 283 48 283 Z\" class=\"highcharts-point highcharts-color-2\"></path>\n" +
                "\t\t\t<path fill=\"#90ed7d\" d=\"M 96 278 L 104 278 104 286 96 286 Z\" class=\"highcharts-point highcharts-color-2\"></path>\n" +
                "\t\t\t<path fill=\"#90ed7d\" d=\"M 145 272 L 153 272 153 280 145 280 Z\" class=\"highcharts-point highcharts-color-2\"></path>\n" +
                "\t\t\t<path fill=\"#90ed7d\" d=\"M 194 271 L 202 271 202 279 194 279 Z\" class=\"highcharts-point highcharts-color-2\"></path>\n" +
                "\t\t\t<path fill=\"#90ed7d\" d=\"M 243 265 L 251 265 251 273 243 273 Z\" class=\"highcharts-point highcharts-color-2\"></path>\n" +
                "\t\t\t<path fill=\"#90ed7d\" d=\"M 291 253 L 299 253 299 261 291 261 Z\" class=\"highcharts-point highcharts-color-2\"></path>\n" +
                "\t\t\t<path fill=\"#90ed7d\" d=\"M 340 242 L 348 242 348 250 340 250 Z\" class=\"highcharts-point highcharts-color-2\"></path>\n" +
                "\t\t</g>\n" +
                "\t\t<g data-z-index=\"0.1\" class=\"highcharts-series highcharts-series-3 highcharts-line-series highcharts-color-3 \" transform=\"translate(73,59) scale(1 1)\" clip-path=\"url(#highcharts-73hgae7-48)\">\n" +
                "\t\t\t<path fill=\"none\" d=\"M 100.89075630252 293.77836 L 149.63025210084 287.38143 L 198.36974789916 282.87864 L 247.10924369748 271.64844 L 295.8487394958 253.368 L 344.58823529412 253.63269\" class=\"highcharts-graph\" data-z-index=\"1\" stroke=\"#f7a35c\" stroke-width=\"2\" stroke-linejoin=\"round\" stroke-linecap=\"round\"></path>\n" +
                "\t\t</g>\n" +
                "\t\t<g data-z-index=\"0.1\" class=\"highcharts-markers highcharts-series-3 highcharts-line-series highcharts-color-3 \" transform=\"translate(73,59) scale(1 1)\" clip-path=\"none\">\n" +
                "\t\t\t<path fill=\"#f7a35c\" d=\"M 100 290 L 104 298 96 298 Z\" class=\"highcharts-point highcharts-color-3\"></path>\n" +
                "\t\t\t<path fill=\"#f7a35c\" d=\"M 149 283 L 153 291 145 291 Z\" class=\"highcharts-point highcharts-color-3\"></path>\n" +
                "\t\t\t<path fill=\"#f7a35c\" d=\"M 198 279 L 202 287 194 287 Z\" class=\"highcharts-point highcharts-color-3\"></path>\n" +
                "\t\t\t<path fill=\"#f7a35c\" d=\"M 247 268 L 251 276 243 276 Z\" class=\"highcharts-point highcharts-color-3\"></path>\n" +
                "\t\t\t<path fill=\"#f7a35c\" d=\"M 295 249 L 299 257 291 257 Z\" class=\"highcharts-point highcharts-color-3\"></path>\n" +
                "\t\t\t<path fill=\"#f7a35c\" d=\"M 344 250 L 348 258 340 258 Z\" class=\"highcharts-point highcharts-color-3\"></path>\n" +
                "\t\t</g>\n" +
                "\t\t<g data-z-index=\"0.1\" class=\"highcharts-series highcharts-series-4 highcharts-line-series highcharts-color-4 \" transform=\"translate(73,59) scale(1 1)\" clip-path=\"url(#highcharts-73hgae7-48)\">\n" +
                "\t\t\t<path fill=\"none\" d=\"M 3.4117647058793 286.25076 L 52.1512605042 296.89956 L 100.89075630252 293.59935 L 149.63025210084 288.79056 L 198.36974789916 292.24683 L 247.10924369748 287.92152 L 295.8487394958 278.04078 L 344.58823529412 278.29017\" class=\"highcharts-graph\" data-z-index=\"1\" stroke=\"#8085e9\" stroke-width=\"2\" stroke-linejoin=\"round\" stroke-linecap=\"round\"></path>\n" +
                "\t\t</g>\n" +
                "\t\t<g data-z-index=\"0.1\" class=\"highcharts-markers highcharts-series-4 highcharts-line-series highcharts-color-4 \" transform=\"translate(73,59) scale(1 1)\" clip-path=\"none\">\n" +
                "\t\t\t<path fill=\"#8085e9\" d=\"M -1 282 L 7 282 3 290 Z\" class=\"highcharts-point highcharts-color-4\"></path>\n" +
                "\t\t\t<path fill=\"#8085e9\" d=\"M 48 293 L 56 293 52 301 Z\" class=\"highcharts-point highcharts-color-4\"></path>\n" +
                "\t\t\t<path fill=\"#8085e9\" d=\"M 96 290 L 104 290 100 298 Z\" class=\"highcharts-point highcharts-color-4\"></path>\n" +
                "\t\t\t<path fill=\"#8085e9\" d=\"M 145 285 L 153 285 149 293 Z\" class=\"highcharts-point highcharts-color-4\"></path>\n" +
                "\t\t\t<path fill=\"#8085e9\" d=\"M 194 288 L 202 288 198 296 Z\" class=\"highcharts-point highcharts-color-4\"></path>\n" +
                "\t\t\t<path fill=\"#8085e9\" d=\"M 243 284 L 251 284 247 292 Z\" class=\"highcharts-point highcharts-color-4\"></path>\n" +
                "\t\t\t<path fill=\"#8085e9\" d=\"M 291 274 L 299 274 295 282 Z\" class=\"highcharts-point highcharts-color-4\"></path>\n" +
                "\t\t\t<path fill=\"#8085e9\" d=\"M 340 274 L 348 274 344 282 Z\" class=\"highcharts-point highcharts-color-4\"></path>\n" +
                "\t\t</g>\n" +
                "\t</g>\n" +
                "\t<g class=\"highcharts-label highcharts-series-label highcharts-series-label-0 \" opacity=\"1\" data-z-index=\"3\" transform=\"translate(353,112)\">\n" +
                "\t\t<path fill=\"none\" class=\"highcharts-label-box\" d=\"M 0 0\" stroke=\"#7cb5ec\" stroke-width=\"1\"></path>\n" +
                "\t\t<text x=\"0\" data-z-index=\"1\" style=\"font-weight:bold;color:#7cb5ec;fill:#7cb5ec;\" y=\"12\">Installation</text>\n" +
                "\t</g>\n" +
                "\t<g class=\"highcharts-label highcharts-series-label highcharts-series-label-1 \" opacity=\"1\" data-z-index=\"3\" transform=\"translate(125,302)\">\n" +
                "\t\t<path fill=\"none\" class=\"highcharts-label-box\" d=\"M 0 0\" stroke=\"#434348\" stroke-width=\"1\"></path>\n" +
                "\t\t<text x=\"0\" data-z-index=\"1\" style=\"font-weight:bold;color:#434348;fill:#434348;\" y=\"12\">Manufacturing</text>\n" +
                "\t</g>\n" +
                "\t<g class=\"highcharts-label highcharts-series-label highcharts-series-label-2 \" opacity=\"1\" data-z-index=\"3\" transform=\"translate(302,288)\">\n" +
                "\t\t<path fill=\"none\" class=\"highcharts-label-box\" d=\"M 0 0\" stroke=\"#90ed7d\" stroke-width=\"1\"></path>\n" +
                "\t\t<text x=\"0\" data-z-index=\"1\" style=\"font-weight:bold;color:#90ed7d;fill:#90ed7d;\" y=\"12\">\n" +
                "\t\t\t<tspan>Sales &amp; Distribution</tspan>\n" +
                "\t\t</text>\n" +
                "\t</g>\n" +
                "\t<g class=\"highcharts-label highcharts-series-label highcharts-series-label-4 \" opacity=\"1\" data-z-index=\"3\" transform=\"translate(383,340)\">\n" +
                "\t\t<path fill=\"none\" class=\"highcharts-label-box\" d=\"M 0 0\" stroke=\"#8085e9\" stroke-width=\"1\"></path>\n" +
                "\t\t<text x=\"0\" data-z-index=\"1\" style=\"font-weight:bold;color:#8085e9;fill:#8085e9;\" y=\"12\">Other</text>\n" +
                "\t</g>\n" +
                "\t<text x=\"300\" text-anchor=\"middle\" class=\"highcharts-title\" data-z-index=\"4\" style=\"color:#333333;font-size:18px;fill:#333333;\" y=\"24\">\n" +
                "\t\t<tspan>Solar Employment Growth by Sector, 2010-2016</tspan>\n" +
                "\t</text>\n" +
                "\t<text x=\"300\" text-anchor=\"middle\" class=\"highcharts-subtitle\" data-z-index=\"4\" style=\"color:#666666;fill:#666666;\" y=\"44\">\n" +
                "\t\t<tspan>Source: thesolarfoundation.com</tspan>\n" +
                "\t</text>\n" +
                "\t<g class=\"highcharts-legend\" data-z-index=\"7\" transform=\"translate(433,157)\">\n" +
                "\t\t<rect fill=\"none\" class=\"highcharts-legend-box\" rx=\"0\" ry=\"0\" x=\"0\" y=\"0\" width=\"157\" height=\"81\" visibility=\"visible\"></rect>\n" +
                "\t\t<g data-z-index=\"1\">\n" +
                "\t\t\t<g>\n" +
                "\t\t\t\t<g class=\"highcharts-legend-item highcharts-line-series highcharts-color-0 highcharts-series-0\" data-z-index=\"1\" transform=\"translate(8,3)\">\n" +
                "\t\t\t\t\t<path fill=\"none\" d=\"M 0 11 L 16 11\" class=\"highcharts-graph\" stroke=\"#7cb5ec\" stroke-width=\"2\"></path>\n" +
                "\t\t\t\t\t<path fill=\"#7cb5ec\" d=\"M 12 11 A 4 4 0 1 1 11.999998000000167 10.996000000666664 Z\" class=\"highcharts-point\"></path>\n" +
                "\t\t\t\t\t<text x=\"21\" style=\"color:#333333;cursor:pointer;font-size:12px;font-weight:bold;fill:#333333;\" text-anchor=\"start\" data-z-index=\"2\" y=\"15\">\n" +
                "\t\t\t\t\t\t<tspan>Installation</tspan>\n" +
                "\t\t\t\t\t</text>\n" +
                "\t\t\t\t</g>\n" +
                "\t\t\t\t<g class=\"highcharts-legend-item highcharts-line-series highcharts-color-1 highcharts-series-1\" data-z-index=\"1\" transform=\"translate(8,17)\">\n" +
                "\t\t\t\t\t<path fill=\"none\" d=\"M 0 11 L 16 11\" class=\"highcharts-graph\" stroke=\"#434348\" stroke-width=\"2\"></path>\n" +
                "\t\t\t\t\t<path fill=\"#434348\" d=\"M 8 7 L 12 11 8 15 4 11 Z\" class=\"highcharts-point\"></path>\n" +
                "\t\t\t\t\t<text x=\"21\" y=\"15\" style=\"color:#333333;cursor:pointer;font-size:12px;font-weight:bold;fill:#333333;\" text-anchor=\"start\" data-z-index=\"2\">\n" +
                "\t\t\t\t\t\t<tspan>Manufacturing</tspan>\n" +
                "\t\t\t\t\t</text>\n" +
                "\t\t\t\t</g>\n" +
                "\t\t\t\t<g class=\"highcharts-legend-item highcharts-line-series highcharts-color-2 highcharts-series-2\" data-z-index=\"1\" transform=\"translate(8,31)\">\n" +
                "\t\t\t\t\t<path fill=\"none\" d=\"M 0 11 L 16 11\" class=\"highcharts-graph\" stroke=\"#90ed7d\" stroke-width=\"2\"></path>\n" +
                "\t\t\t\t\t<path fill=\"#90ed7d\" d=\"M 4 7 L 12 7 12 15 4 15 Z\" class=\"highcharts-point\"></path>\n" +
                "\t\t\t\t\t<text x=\"21\" y=\"15\" style=\"color:#333333;cursor:pointer;font-size:12px;font-weight:bold;fill:#333333;\" text-anchor=\"start\" data-z-index=\"2\">\n" +
                "\t\t\t\t\t\t<tspan>Sales &amp; Distribution</tspan>\n" +
                "\t\t\t\t\t</text>\n" +
                "\t\t\t\t</g>\n" +
                "\t\t\t\t<g class=\"highcharts-legend-item highcharts-line-series highcharts-color-3 highcharts-series-3\" data-z-index=\"1\" transform=\"translate(8,45)\">\n" +
                "\t\t\t\t\t<path fill=\"none\" d=\"M 0 11 L 16 11\" class=\"highcharts-graph\" stroke=\"#f7a35c\" stroke-width=\"2\"></path>\n" +
                "\t\t\t\t\t<path fill=\"#f7a35c\" d=\"M 8 7 L 12 15 4 15 Z\" class=\"highcharts-point\"></path>\n" +
                "\t\t\t\t\t<text x=\"21\" y=\"15\" style=\"color:#333333;cursor:pointer;font-size:12px;font-weight:bold;fill:#333333;\" text-anchor=\"start\" data-z-index=\"2\">\n" +
                "\t\t\t\t\t\t<tspan>Project Development</tspan>\n" +
                "\t\t\t\t\t</text>\n" +
                "\t\t\t\t</g>\n" +
                "\t\t\t\t<g class=\"highcharts-legend-item highcharts-line-series highcharts-color-4 highcharts-series-4\" data-z-index=\"1\" transform=\"translate(8,59)\">\n" +
                "\t\t\t\t\t<path fill=\"none\" d=\"M 0 11 L 16 11\" class=\"highcharts-graph\" stroke=\"#8085e9\" stroke-width=\"2\"></path>\n" +
                "\t\t\t\t\t<path fill=\"#8085e9\" d=\"M 4 7 L 12 7 8 15 Z\" class=\"highcharts-point\"></path>\n" +
                "\t\t\t\t\t<text x=\"21\" y=\"15\" style=\"color:#333333;cursor:pointer;font-size:12px;font-weight:bold;fill:#333333;\" text-anchor=\"start\" data-z-index=\"2\">\n" +
                "\t\t\t\t\t\t<tspan>Other</tspan>\n" +
                "\t\t\t\t\t</text>\n" +
                "\t\t\t\t</g>\n" +
                "\t\t\t</g>\n" +
                "\t\t</g>\n" +
                "\t</g>\n" +
                "\t<g class=\"highcharts-axis-labels highcharts-xaxis-labels \" data-z-index=\"7\">\n" +
                "\t\t<text x=\"76.411764705879\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;\" text-anchor=\"middle\" transform=\"translate(0,0)\" y=\"384\" opacity=\"1\">2010</text>\n" +
                "\t\t<text x=\"173.89075630252\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;\" text-anchor=\"middle\" transform=\"translate(0,0)\" y=\"384\" opacity=\"1\">2012</text>\n" +
                "\t\t<text x=\"271.36974789916\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;\" text-anchor=\"middle\" transform=\"translate(0,0)\" y=\"384\" opacity=\"1\">2014</text>\n" +
                "\t\t<text x=\"368.8487394958\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;\" text-anchor=\"middle\" transform=\"translate(0,0)\" y=\"384\" opacity=\"1\">2016</text>\n" +
                "\t</g>\n" +
                "\t<g class=\"highcharts-axis-labels highcharts-yaxis-labels \" data-z-index=\"7\">\n" +
                "\t\t<text x=\"58\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;\" text-anchor=\"end\" transform=\"translate(0,0)\" y=\"370\" opacity=\"1\">0</text>\n" +
                "\t\t<text x=\"58\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;\" text-anchor=\"end\" transform=\"translate(0,0)\" y=\"294\" opacity=\"1\">50k</text>\n" +
                "\t\t<text x=\"58\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;\" text-anchor=\"end\" transform=\"translate(0,0)\" y=\"217\" opacity=\"1\">100k</text>\n" +
                "\t\t<text x=\"58\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;\" text-anchor=\"end\" transform=\"translate(0,0)\" y=\"141\" opacity=\"1\">150k</text>\n" +
                "\t\t<text x=\"58\" style=\"color:#666666;cursor:default;font-size:11px;fill:#666666;\" text-anchor=\"end\" transform=\"translate(0,0)\" y=\"64\" opacity=\"1\">200k</text>\n" +
                "\t</g>\n" +
                "\t<text x=\"590\" class=\"highcharts-credits\" text-anchor=\"end\" data-z-index=\"8\" style=\"cursor:pointer;color:#999999;font-size:9px;fill:#999999;\" y=\"395\">Highcharts.com</text>\n" +
                "</svg>";

        try {
            InputStream inputStream = new ByteArrayInputStream(imageString.getBytes());
            String parser = XMLResourceDescriptor.getXMLParserClassName();
            SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
            Document doc = f.createDocument("http://www.w3.org/2000/svg", inputStream);

            TranscoderInput svgImage = new TranscoderInput(doc);

            OutputStream pngOutputStream = new FileOutputStream("/home/rumman/Desktop/image5.png");
            TranscoderOutput pngImage = new TranscoderOutput(pngOutputStream);

            PNGTranscoder converter = new PNGTranscoder();

            converter.transcode(svgImage, pngImage);

            pngOutputStream.flush();
            pngOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
