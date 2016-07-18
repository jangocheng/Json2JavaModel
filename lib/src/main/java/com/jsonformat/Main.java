package com.jsonformat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import javax.annotation.processing.Filer;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

public class Main {

    public static void main(String[] args) {
        String jsonStr;

        
        jsonStr = "{\n" +
                "    \"name\": \"jack\",\n" +
                "    \"gender\": \"man\",\n" +
                "    \"age\": 15,\n" +
                "    \"height\": \"140cm\",\n" +
                "}";
        
        jsonStr = "{\n" +
                "    \"name\": \"jack\",\n" +
                "    \"gender\": \"man\",\n" +
                "    \"age\": 15,\n" +
                "    \"height\": \"140cm\",\n" +
                "    \"addr\": {\n" +
                "        \"province\": \"fujian\",\n" +
                "        \"city\": \"quanzhou\",\n" +
                "        \"code\": \"300000\"\n" +
                "    },\n" +
                "    \"hobby\": [\n" +
                "        {\n" +
                "            \"name\": \"billiards\",\n" +
                "            \"code\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"computerGame\",\n" +
                "            \"code\": \"2\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        
        jsonStr = "{\n"
                + "    \"id\": 100,\n"
                + "    \"body\": \"It is my post\",\n"
                + "    \"number\": 0.13,\n"
                + "    \"created_at\": \"2014-05-22 19:12:38\",\n"
                + "    \"foo2\": {\n"
                + "        \"id\": 200,\n"
                + "        \"name\": \"haha\"\n"
                + "    }\n"
                + "}";

        jsonStr = "{\n"
                + "  \"status\": 1,\n"
                + "  \"data\": \n"
                + "  {\n"
                + "    \"more\": 1,\n"
                + "    \"next_start\": 24,\n"
                + "    \"object_list\": [{\n"
                + "        \"photo\": \n"
                + "        {\n"
                + "          \"width\": 480,\n"
                + "          \"height\": 698,\n"
                + "          \"path\": \"http://cdn.duitang.com/uploads/item/201508/13/20150813235841_2FjJA.png\"\n"
                + "        },\n"
                + "        \"msg\": \"pվ\",\n"
                + "        \"id\": 427355390,\n"
                + "        \"buyable\": 0,\n"
                + "        \"source_link\": \"\",\n"
                + "        \"add_datetime\": \"23:58\",\n"
                + "        \"add_datetime_pretty\": \"1Сʱǰ\",\n"
                + "        \"add_datetime_ts\": 1439481522,\n"
                + "        \"sender_id\": 8828896,\n"
                + "        \"favorite_count\": 0,\n"
                + "        \"extra_type\": \"PICTURE\"\n"
                + "      }]\n"
                + "  }\n"
                + "}";
        jsonStr = "{\n" +
                "\"kind\": \"youtube#searchListResponse\",\n" +
                "\"etag\": \"\\\"k1sYjErg4tK7WaQQxvJkW5fVrfg/usRLzp_l5ss-L8Yb9ScY-VDAEOo\\\"\",\n" +
                "\"nextPageToken\": \"CAIQAA\",\n" +

                "\"pageInfo\": {\n" +
                "\"totalResults\": 1000000,\n" +
                "\"resultsPerPage\": 2\n" +
                "},\n" +
                "\"items\": [\n" +
                "{\n" +
                "\"kind\": \"youtube#searchResult\",\n" +
                "\"etag\": \"\\\"k1sYjErg4tK7WaQQxvJkW5fVrfg/D0nlqgSgFFEQnTduJtwcQZ3Hc78\\\"\",\n" +
                "\"id\": {\n" +
                "\"kind\": \"youtube#video\",\n" +
                "\"videoId\": \"5ixFWqZGZr8\"\n" +
                "},\n" +
                "\"snippet\": {\n" +
                "\"publishedAt\": \"2014-10-16T19:43:41.000Z\",\n" +
                "\"channelId\": \"UC9-3c4LzdzT_HvW3Xuti9wg\",\n" +
                "\"title\": \"Q&A WITH HARRY | PRANK CALLS!\",\n" +
                "\"description\": \"Can we smash 4000 likes for this Q&A!? My Flatmate Harold - http://www.youtube.com/W2S Buy Cheap and Instant Coins here: http://goo.gl/IZyNg2 Use code ...\",\n" +
                "\"thumbnails\": {\n" +
                "\"default\": {\n" +
                "\"url\": \"https://i.ytimg.com/vi/5ixFWqZGZr8/default.jpg\"\n" +
                "},\n" +
                "\"medium\": {\n" +
                "\"url\": \"https://i.ytimg.com/vi/5ixFWqZGZr8/mqdefault.jpg\"\n" +
                "},\n" +
                "\"high\": {\n" +
                "\"url\": \"https://i.ytimg.com/vi/5ixFWqZGZr8/hqdefault.jpg\"\n" +
                "}\n" +
                "},\n" +
                "\"channelTitle\": \"Calfreezy\",\n" +
                "\"liveBroadcastContent\": \"none\"\n" +
                "}\n" +
                "},\n" +
                "{\n" +
                "\"kind\": \"youtube#searchResult\",\n" +
                "\"etag\": \"\\\"k1sYjErg4tK7WaQQxvJkW5fVrfg/R5nmI-OBXmHyiXsGtMC3J6IUlBs\\\"\",\n" +
                "\"id\": {\n" +
                "\"kind\": \"youtube#video\",\n" +
                "\"videoId\": \"8KgzATFR0As\"\n" +
                "},\n" +
                "\"snippet\": {\n" +
                "\"publishedAt\": \"2014-09-03T12:49:15.000Z\",\n" +
                "\"channelId\": \"UC8_yRRDIGFaJEC7NOc1qTMw\",\n" +
                "\"title\": \"Harry at 30 Documentary\",\n" +
                "\"description\": \"In celebration of Prince Harry's 30th birthday, ITV have released a new documentary celebrating the past three decades of his life. Featuring archive footage...\",\n" +
                "\"thumbnails\": {\n" +
                "\"default\": {\n" +
                "\"url\": \"https://i.ytimg.com/vi/8KgzATFR0As/default.jpg\"\n" +
                "},\n" +
                "\"medium\": {\n" +
                "\"url\": \"https://i.ytimg.com/vi/8KgzATFR0As/mqdefault.jpg\"\n" +
                "},\n" +
                "\"high\": {\n" +
                "\"url\": \"https://i.ytimg.com/vi/8KgzATFR0As/hqdefault.jpg\"\n" +
                "}\n" +
                "},\n" +
                "\"channelTitle\": \"\",\n" +
                "\"liveBroadcastContent\": \"none\"\n" +
                "}\n" +
                "}\n" +
                "]\n" +
                ",\"zddd\": {\n" +
                "\"url\": \"https://i.ytimg.com/vi/8KgzATFR0As/default.jpg\"\n" +
                "},\n" +
                "}";

        JsonParserHelper jsonParser = new JsonParserHelper();

        final String packageName = "panda";
        final String clsName = "Test";
        jsonParser.parse(jsonStr, clsName, new JsonParserHelper.ParseListener() {
            public void onParseComplete(String str) {
                createModelClass(packageName, clsName, "package " + packageName + ";\n" + str);
            }

            public void onParseError(Exception e) {
                e.printStackTrace();
                fatalError(e.getMessage());
            }
        });
        log("Complete on: ");
    }

    private static void createModelClass(String packageName, String clsName, String content) {
        //PackageElement pkgElement = elementUtils.getPackageElement("");

        //TODO content内容需要分类class内容
        OutputStreamWriter osw = null;
        try {
            // create a model file
            OutputStream os = new FileOutputStream(new File(clsName+".java"));
            osw = new OutputStreamWriter(os, Charset.forName("UTF-8"));
            osw.write(content, 0, content.length());

        } catch (IOException e) {
            e.printStackTrace();
            fatalError(e.getMessage());
        } finally {
            try {
                if (osw != null) {
                    osw.flush();
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                fatalError(e.getMessage());
            }
        }
    }

    private static void log(String msg) {
        System.out.println(msg);
//        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, TAG + msg);
    }

    private static void fatalError(String msg) {
        System.out.println(msg);
//        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, TAG + " FATAL ERROR: " + msg);
    }
}
