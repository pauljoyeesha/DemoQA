package qaclickacademy.text.context;

import qaclickacademy.PageObjectManager.PageManager;
import qaclickacademy.TestBase.Base;

 

public class TextContext {

               

                private PageManager pageObjectManager;

               

               // private PageObjectManagerIETL PageObjectManagerIETL;

                private ScenarioContext scenarioContext;

                //private PageObjectManagerIBM PageObjectManagerIBM;

               

                public TextContext(){

                               

                                pageObjectManager = new PageManager(Base.getWebDriver());

                                //PageObjectManagerIETL=new PageObjectManagerIETL(TestBase.getWebDriver2());

                               // PageObjectManagerIBM=new PageObjectManagerIBM(TestBase.getWebDriver());

                               

                                scenarioContext = new ScenarioContext();

                }

               

               

               

                public PageManager getPageManager() {

                                return pageObjectManager;

                }

                /*public PageObjectManagerIBM getPageObjectManagerIBM() {

                                return PageObjectManagerIBM;

                }*/

               /* public PageObjectManagerIETL getPageObjectManagerIETL() {

                                return PageObjectManagerIETL;

                }*/

                public ScenarioContext getScenarioContext() {

                                return scenarioContext;

                }

}
