//package qaclickacademy.TestBase;
//
//import org.testng.asserts.SoftAssert;
//
//
//
//public class SoftAsserSingleton {
//
// 
//
//       private static SoftAsserSingleton softAss;
//
//       public SoftAssert soft;
//
//       private SoftAsserSingleton()
//
//       {
//
//             
//
//       }
//
//      
//
//       public SoftAssert softAssert()
//
//       {
//
//       return soft =new SoftAssert();
//
//       }
//
//      
//
//       public static SoftAsserSingleton getInstance()
//
//       {
//
//              if(softAss==null)
//
//              {
//
//                     return softAss=new SoftAsserSingleton();     
//
//              }
//
//              else
//
//              {
//
//                     return softAss;    
//
//              }
//
//       }
//
//}