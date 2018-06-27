//package com.form16.qa.base;
//
//import org.eclipse.core.resources.IProject;
//import org.eclipse.core.resources.IResource;
//import org.eclipse.core.resources.IWorkspaceRoot;
//import org.eclipse.core.resources.ResourcesPlugin;
//import org.eclipse.core.runtime.NullProgressMonitor;
//import org.testng.annotations.Test;
//
//import com.form16.qa.utility.TestUtil;
//import com.form16.qa.utility.Xl;
//
//public class GenerateReport {
//	
//	
//	@Test
//	  public void generateReport() throws Exception{
//		
////		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
////		IProject project = myWorkspaceRoot.getProject("Form16");
////		 if(project.exists() && project!=null){
////			 
////			 project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
////		 }
//		
//		for(IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()){
//		    project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
//		}
//
////		Thread.sleep(10000);
////		Xl.generateReport("excel-report.xlsx");
//		
//		
//	  }
//	
//	
//	
//	
//	
//	
//
//	
//	
//
//}
