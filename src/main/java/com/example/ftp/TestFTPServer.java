/*******************************************************************************
 * Copyright (c) 2017, 2017 Hirain Technologies Corporation.
 ******************************************************************************/
package com.example.ftp;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version 1.0
 * @Author hao.zheng@hirain.com
 * @Created Aug 23, 2017 3:59:36 PM
 * @Description
 *              <p>
 * @Modification
 *               <p>
 *               Date Author Version Description
 *               <p>
 *               Aug 23, 2017 hao.zheng@hirain.com 1.0 create file
 */
public class TestFTPServer {

	/**
	 *
	 */
	private static final String PATH = "E:/test";

	public static void main(final String[] args) throws Exception {
		TestFTPServer.createServer();
	}

	public static FtpServer createServer(String path) throws FtpException {
		final FtpServerFactory factory = new FtpServerFactory();
		// final BaseUser user = createUserUser();
		{
			final BaseUser user = createAnonyUser();
			factory.getUserManager().save(user);
		}
		{
			final BaseUser user = createUserUser();
			factory.getUserManager().save(user);
		}
		{
			final BaseUser user = createUser("root", "toorHirain", path, false);
			factory.getUserManager().save(user);
		}
		final FtpServer server = factory.createServer();
		server.start();
		return server;
	}

	public static FtpServer createServer() throws FtpException {
		return createServer(PATH);
	}

	/**
	 * @return
	 */
	public static BaseUser createUser(final String name, final String passward, final String directory, final boolean readOnly) {
		final BaseUser user = new BaseUser();
		user.setName(name);
		user.setPassword(passward);
		user.setHomeDirectory(directory);
		if (!readOnly) {
			final List<Authority> authorities = new ArrayList<Authority>();
			authorities.add(new WritePermission());
			user.setAuthorities(authorities);
		}
		return user;
	}

	/**
	 * @return
	 */
	private static BaseUser createAnonyUser() {
		return createUser("anonymous", null, PATH, false);
	}

	/**
	 * @return
	 */
	private static BaseUser createUserUser() {
		return createUser("user", "user", PATH, false);
	}

}
