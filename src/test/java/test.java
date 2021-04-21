
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xll.entity.DavpMailConfigPo;
import com.xll.entity.po.UsersPo;
import com.xll.mapper.UsersMapper;
import com.xll.testApplication;
import net.minidev.json.JSONUtil;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author : XuLeLe
 * @Date : 2021/01/27/10:01
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = testApplication.class)
public class test {

   @Resource
    private UsersMapper usersMapper;
   Map<String,Integer> map = new HashMap();

    @Test
    public void test() {
        List<UsersPo> studentList = usersMapper.selectList(null);
        Assert.assertEquals(studentList.size(),studentList.size());
        studentList.forEach(System.out::println);
        System.out.println(System.getProperty("user.dir"));
    }
    @Test
    public void test2() {
        List<UsersPo> list = usersMapper.selectList(null);
        list.forEach((usersPo -> {
            System.out.println(usersPo);
        }));
    }

    @Test
    public void testMap() {
        Map<Integer,Integer> map = new HashMap();
        map.put(1,4);
        System.out.println(map.get(1).toString().concat("hello world"));
    }
    @Test
    public void testUUID() {
        String s = UUID.randomUUID().toString();
        System.out.println(s);
        String s1 = s.replaceAll("-", "");
        System.out.println(s1);
    }

    @Test
    public void testDate(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z").format(new Date(System.currentTimeMillis())).substring(0,10));
    }

    @Test
    public void  testCalendar(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( new Date());
        //给当前时间加上指定秒数后的时间
        calendar.add(Calendar.SECOND,20);
        System.out.println(calendar.getTime());
    }

    @Test
    public void testString(){
        String str = "12345671";
        System.out.println(str.substring(7).equals("1"));
    }
    @Test
    public void testMap2(){
              map.put("a",1);

        System.out.println(map.get("a"));
    }

    @Test
    public void testStream(){
        List<String> collect = Stream.of("1", "2", "3").collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect.size());
    }

    @Test
    public void testMap1(){
        Map<String,String> map1 = new HashMap();
        map1.put("1","nihao");
        System.out.println(map1);
    }

    @Test
    public void testSubstring(){
        String str= "abc123";
        String substring = str.substring(str.length() - 1);
        System.out.println(substring);
    }

    @Test
    public void testStringIndexOf(){
        String str = "abcdefg";
        System.out.println(str.toString().indexOf("df"));
    }

    @Test
    public void testUrlEncode(){
        String str = "{\"teamName\":\"nj_kpi\",\"currPage\":1,\"pageSize\":10}";
        String decode = URLDecoder.decode(str);
        String encode = URLEncoder.encode(str);

        System.out.println("UrlEncode:" + encode);
        System.out.println("UrlDecode:" + decode);

    }

    @Test
    public void testMap3(){
        Map<String,String> map1 = new HashMap();
       String teamName = "nj_kpi";
       Integer currPage = 1;
       Integer pageSize = 10;
        map1.put("A","1");
        map1.put("B","1");
        map1.put("C","1");
        String str = "{\"teamName\":\"nj_kpi\",\"currPage\":1,\"pageSize\":10}";
        //{"teamName":"nj_kpi","currPage":1,"pageSize":10}
        String str2 = "{" + "\"teamName" + "\":" + "\"" +teamName + "\"," + "\"currPage" + "\":"  +currPage + "," + "\"pageSize" + "\":" + pageSize + "}";
        System.out.println("\"1");
        System.out.println(str2);

        System.out.println(str);
        System.out.println(URLEncoder.encode(str));
    }

    @Test
    public void testJson(){
        List<String> list = new ArrayList<>();
        list.add("rptId");
        list.add("dataIndex");

        Map<String, Object> rptInfo = new HashMap<>();
        rptInfo.put("rptInfo", list);

        List<Map<String, Object>> contentInfo = new ArrayList<>();
        contentInfo.add(rptInfo);

        String s = JSON.toJSONString(contentInfo);
        System.out.println(s); //[{"rptInfo":["AAA","BBB","CCC"]}]

        List<Map> maps = JSONObject.parseArray(s, Map.class);
        maps.forEach(map -> {
            JSONArray rptInfo1 = ((JSONArray) map.get("rptInfo"));
            System.out.println(rptInfo1.get(0));
            System.out.println(rptInfo1.get(1));
        });
    }

    @Test
    public void testJson2(){
        String str = "[{\"rptInfo\":[\"jG3lSuOO\",\"KPI_DATE\"]},{\"rptInfo\":[\"jG3lSuOO\",\"KPI_DATE\"]}]";
        List<Map> maps = JSONObject.parseArray(str, Map.class);
        System.out.println(maps);
        //[{rptInfo=["jG3lSuOO","KPI_DATE"]}, {rptInfo=["jG3lSuOO","KPI_DATE"]}]
    }

    @Test
    public void testRestemplate(){
        DavpMailConfigPo davpMailConfigPo = new DavpMailConfigPo();
        davpMailConfigPo.setContentType("[{\"rptInfo\":[\"jG3lSuO1\",\"KPI_DATE\"]},{\"rptInfo\":[\"jG3lSuOO\",\"KPI_DATE\"]}]");
        //String contentType = davpMailConfigPo.getContentType();
        List<Map> maps = JSONObject.parseArray(davpMailConfigPo.getContentType(), Map.class);
        System.out.println(maps);
        /**
         * {
         *   "appCode": "davp",
         *   "rptMaps":[
         *     {
         *       "rptId": "DNYWY13D",
         *       "dateField": "DATE"
         *     },
         *     {
         *       "rptId": "DNYWY13D",
         *       "dateField": "DATE"
         *     }
         *   ],
         *   "addAttachment": false
         * }
         */
        List list1 = (List) (maps.get(0).get("rptInfo"));
        System.out.println(list1.get(0));
        System.out.println(maps.get(0).get("rptInfo"));
        System.out.println(maps.get(0).get("dateField"));
        List rptMaps = new ArrayList();

        for (int i = 0; i < maps.size(); i++) {
            Map<String,Object> map = new HashMap();
            map.put("rptId",((List) (maps.get(i).get("rptInfo"))).get(0));
            map.put("dateField",((List) (maps.get(i).get("rptInfo"))).get(1));
            rptMaps.add(map);
        }

        System.out.println("==================");
        System.out.println(rptMaps);
        System.out.println(maps.size());
        Map<String,Object> map1 = new HashMap<>();
        map1.put("appCode","davp");
        map1.put("addAttachment","false");
        map1.put("rptMaps",rptMaps);
        System.out.println(map1);
    }

    @Test
    public void testIfElse(){
        String str = "0";
        if(str.equals("0")){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    @Test
    public void testStringArray(){
        String str = "DCD002L00003,MCD001L00001,MCD001L00002,MCD002L00001,MCD002L00003,";
        List list = new ArrayList();
        String[] strs = str.split(",") ;
        System.out.println(strs);
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].startsWith("M")){
             list.add(strs[i]);
            }
        }
       // System.out.println(list);
    }
    
    @Test
    public void testGetStringArray() {
        String A = "aaa";
        String B = "bbb";
        String C = "CCC";

    }
    @Test
    public void testLambda1() {
        List list = new ArrayList();
        List list2 = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.forEach(System.out::println);
        list.forEach((value) -> list2.add(value));
        list2.forEach(System.out::println);
    }
    @Test
    public void testDatetime(){
        DateTime dateTime =  new DateTime().minusDays(1);
        System.out.println(dateTime);
        System.out.println(dateTime.toString("yyyyMMdd"));
        System.out.println(dateTime.minusMonths(1).toString("yyyyMM"));
    }
    @Test
    public void testStringArray2(){
        String str = "16:00";
        String[] split = str.split(":");
        System.out.println(split[0] + "---" + split[1]);
        DateTime nowDt = new DateTime();
        DateTime dataBaseDt = new DateTime(nowDt.getYear(),nowDt.getMonthOfYear(),nowDt.getDayOfMonth(),Integer.parseInt(split[0]),Integer.parseInt(split[1]),00);
        System.out.println(dataBaseDt.plusMinutes(15).plusDays(1));
        System.out.println(dataBaseDt.plusMinutes(15).plusDays(1).toString("yyyy/MM/dd HH:mm:ss"));
    }
    
    @Test
    public void isEmpty(){
        String str = "";
        System.out.println(str.isEmpty());
        String str2 = "123";
        System.out.println(Double.parseDouble(str2));
    }

    @Test
    public void testStringConcat(){
        String str = "你好";
        str = str.concat("ssss");
        System.out.println(str);

        System.out.println( 1 >= 2);
        System.out.println(2 >= 2);
        System.out.println( 2>=1 && 2<=3);
    }

    @Test
    public void quchong () {
        String test="100,120,166,1555,120,150,100";
        String[] test1=test.split(",");
        ArrayList list=new ArrayList();
        for(int i=0;i<test1.length;i++)
        {
            if(!list.contains(test1[i]))
                list.add(test1[i]);
        }
        System.out.println("hehe"+list.size()+"haha");
        for(int i=0;i<list.size();i++)
            System.out.println("hehe"+list.get(i));
        }

    @Test
    public void quchong2 () {
       List list1 = new ArrayList();
       list1.add("a");
       list1.add("b");
       list1.add("c");
       list1.add("d");
       list1.add("a");
//        for (int i = 0; i < list1.size(); i++) {
//             if(list1.get(i).equals("a")){
//                 list1.remove(i);
//             }
//        }
        System.out.println(list1.stream().collect(Collectors.toSet()));
        System.out.println(list1);
    }

    @Test
    public void testCollectortolist(){
        Set set =  new HashSet();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        System.out.println("set..................");
        System.out.println(set);
        System.out.println(set.stream().collect(Collectors.toList()));
        Map map = new HashMap();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        System.out.println("map..................");
        System.out.println(map);
        for (Object m : map.values()){
            System.out.println(m);
        }
    }
}
