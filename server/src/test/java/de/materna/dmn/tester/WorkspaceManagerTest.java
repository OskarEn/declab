package de.materna.dmn.tester;

import de.materna.dmn.tester.persistence.WorkspaceManager;
import de.materna.dmn.tester.servlets.workspace.beans.Workspace;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
/***
 * 
 * @author oenmalm (OskarEn)
 * Introduced to test the new methods within WorkspaceManager
 *
 */
public class WorkspaceManagerTest {
	
	final String key1 = "start";
	final String key2 = "end";
	WorkspaceManager wsm = WorkspaceManager.getInstance();
	
	
	@Test
	void getCreatesNewWorkspaceWithKeyWhenNotFound() throws IOException {
		Workspace workspace = getWorkspace(key1);
		assertNotNull(workspace);
		assertEquals(true, wsm.workplaceExists(key1));
	}
	
	@Test
	void isRenameSuccessful() throws IOException {
		//Setup
		Workspace workspace = getWorkspace(key1);
		wsm.rename(key1, key2);

		assertEquals(true, wsm.workplaceExists(key2));
		assertEquals(false, wsm.workplaceExists(key1));
		assertEquals(workspace, wsm.get(key2));
	}
	
	private Workspace getWorkspace(String key) throws IOException {
		Workspace aWorkspace = wsm.get(key);
		return aWorkspace;
	}

}
