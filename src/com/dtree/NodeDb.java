package com.dtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ObjectGeter.*;
import com.bsObject.*;

public class NodeDb {
	public final static String ICON_FOLDER = "\"img/folder.gif\"";
	public final static String ICON_FOLDEROPEN = "\"img/folderopen.gif\""; 
	public final static String ICON_NODE = "\"img/page.gif\""; 
	public final static String ICON_ORG = "\"img/globe.gif\""; 
	public final static String ICON_USER = "\"img/cd.gif\""; 
	public final static int TYPE_ROOT = -1;
	public final static int TYPE_NORMAL = 0;
	public final static int TYPE_USER = 1;
	public final static int TYPE_ROLE = 2;
	public final static int TYPE_FUNCTION = 3;
	public final static int TYPE_MODULE = 4;
	public final static int TYPE_ORG = 5;

	private static List<Node> treeList;

	public NodeDb() {
		treeList = new ArrayList<Node>();
		ModuleNodeAdd();
		FunctionNodeAdd();
		OrgNodeAdd();
		UserNodeAdd();
	}

	public void FunctionNodeAdd() {
		Node node = null;
		for (Function function : Function_geter.getAll()) {
			node = new Node(Integer.parseInt(function.getFunction_id()),
					function.getFunction_name(), Integer.parseInt(function
							.getModule_id()), TYPE_FUNCTION);
			treeList.add(node);

		}
	} 

	public void UserNodeAdd() {
		Node node = null;
		for (User user : User_geter.getAll()) {
			node = new Node(Integer.parseInt(user.getUser_id()),
					user.getUser_name(), Integer.parseInt(user.getOrg_id()),
					TYPE_USER);
			treeList.add(node);
		}
	}

	public void ModuleNodeAdd() {
		Node node = null;
		for (Module module : Module_geter.getAll()) {
			node = new Node(Integer.parseInt(module.getModule_id()),
					module.getModule_name(), Integer.parseInt(module
							.getUp_module_id()), module.getModule_url(),
					TYPE_MODULE);
			if (node.getId() == 0)
				node.setType(TYPE_ROOT);
			treeList.add(node);
		}
	}

	public void OrgNodeAdd() {
		Node node = null;
		for (Org org : Org_geter.getAll()) {
			node = new Node(Integer.parseInt(org.getOrg_id()),
					org.getOrg_name(), Integer.parseInt(org.getUp_org_id()),
					TYPE_ORG);
			treeList.add(node);
		}
	}

	public List<Node> getNodes() {
		return treeList;
	}

	public String getJSTreeString() {
		Iterator<Node> treeIt = getNodes().iterator();
		StringBuffer sbf = new StringBuffer();
		sbf.append("dtree = new dTree(\"dtree\");");
		while (treeIt.hasNext()) {
			// JS鍑芥暟椤哄簭锛歩d, pid, name, url, title, target, icon, iconOpen, open
			Node nd = treeIt.next();
			// 澧炲姞 js鏍戠粨鐐�
			String str = nd.getId() + "," + nd.getPId() + ",\"" + nd.getName()
					+ "\"";
			switch (nd.getType()) {
			case TYPE_ROOT:
				break;
			case TYPE_USER:
				str += ",\"Usermanage.jsp?uid=" + nd.getId() + "\"," + 0
						+ ",\"centerpag\"," + ICON_USER;
				break;
			case TYPE_ROLE:
				break;
			case TYPE_FUNCTION:
				str += ",\"FunctionNodeManage.jsp?fid=" + nd.getId() + "\","
						+ 0 + ",\"centerpag\"";
				break;
			case TYPE_MODULE:
				str += ",\"ModuleNodeManage.jsp?mid=" + nd.getId() + "\"," + 0
						+ ",\"centerpag\"," + ICON_FOLDER + ","
						+ ICON_FOLDEROPEN;
				break;
			case TYPE_ORG:
				str += ",\"OrgNodeManage.jsp?oid=" + nd.getId() + "\"," + 0
						+ ",\"centerpag\"," + ICON_ORG + "," + ICON_ORG;
				break;
			default:
				break;
			}

			sbf.append("dtree.add(" + str + ");");
		}


		sbf.append("document.write(dtree);");

		return sbf.toString();
	}

}
