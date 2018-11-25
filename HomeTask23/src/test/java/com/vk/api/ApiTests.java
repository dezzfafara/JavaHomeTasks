package com.vk.api;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.comparesEqualTo;
import static org.testng.Assert.assertTrue;

public class ApiTests {
	private final static int SUCCESS_SEND_MESSAGE_CODE = 200;
	private final static int SUCCESS_RESPONSE = 1;
	private final static String PATTERN = "^[0-9]+$";
	private String messageText;
	private ApiHandler apiHandler;

	@BeforeClass()
	public void setUp() {
		apiHandler = new ApiHandler();
		messageText = "";
	}

	@Parameters({ "sendMessagePath", "userId", "userIdValue", "attachment", "attachmentValue", "accessToken",
			"accessTokenValue", "version", "versionValue"

	})
	@Test(priority = 1)
	public void sendPhoto(String sendMessagePath, String userId, String userIdValue, String attachment,
			String attachmentValue, String accessToken, String accessTokenValue, String version, String versionValue)
			throws ClientProtocolException, URISyntaxException, IOException {
		apiHandler.sendMessage(sendMessagePath, userId, userIdValue, attachment, attachmentValue, accessToken,
				accessTokenValue, version, versionValue);
		assertThat(apiHandler.getStatusCode(), comparesEqualTo(SUCCESS_SEND_MESSAGE_CODE));
		assertTrue(apiHandler.isSuccessfullResponse(PATTERN));
	}

	@Parameters({ "sendMessagePath", "userId", "userIdValue", "message", "messageValue", "accessToken",
			"accessTokenValue", "version", "versionValue"

	})
	@Test(priority = 2)
	public void sendMessage(String sendMessagePath, String userId, String userIdValue, String message,
			String messageValue, String accessToken, String accessTokenValue, String version, String versionValue)
			throws ClientProtocolException, URISyntaxException, IOException {
		apiHandler.sendMessage(sendMessagePath, userId, userIdValue, message,
				messageValue + apiHandler.randomGenerator(), accessToken, accessTokenValue, version, versionValue);
		assertThat(apiHandler.getStatusCode(), comparesEqualTo(SUCCESS_SEND_MESSAGE_CODE));
		assertTrue(apiHandler.isSuccessfullResponse("^[0-9]+$"));
	}

	@Parameters({ "getByIdPath", "editMessagePath", "messageId", "messageIds", "message", "editedMessage", "peerId",
			"userIdValue", "accessToken", "accessTokenValue", "version", "versionValue" })
	@Test(priority = 3, enabled = true)
	public void editMessage(String getByIdPath, String editMessagePath, String messageId, String messageIds,
			String message, String editedMessage, String peerId, String userIdValue, String accessToken,
			String accessTokenValue, String version, String versionValue)
			throws ClientProtocolException, URISyntaxException, IOException {
		messageText = apiHandler.getMessageText(getByIdPath, messageIds, apiHandler.getMessageId(), accessToken,
				accessTokenValue, version, versionValue);
		apiHandler.editMessage(editMessagePath, peerId, userIdValue, messageId, apiHandler.getMessageId(), message,
				messageText + editedMessage, accessToken, accessTokenValue, version, versionValue);
		assertThat(apiHandler.getDigitResponseValue(), comparesEqualTo(SUCCESS_RESPONSE));
	}

	@Parameters({ "deleteMessagePath", "messageIds", "deleteForAll", "deleteForAllValue", "accessToken",
			"accessTokenValue", "version", "versionValue" })
	@Test(priority = 4)
	public void deleteMessage(String deleteMessagePath, String messageIds, String deleteForAll,
			String deleteForAllValue, String accessToken, String accessTokenValue, String version, String versionValue)
			throws ClientProtocolException, URISyntaxException, IOException {
		apiHandler.deleteMessage(deleteMessagePath, messageIds, apiHandler.getMessageId(), deleteForAll,
				deleteForAllValue, accessToken, accessTokenValue, version, versionValue);
		assertThat(apiHandler.getDigitResponseValue(apiHandler.getMessageId()), comparesEqualTo(SUCCESS_RESPONSE));
	}

}
