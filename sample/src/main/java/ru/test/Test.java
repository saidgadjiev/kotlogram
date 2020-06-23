package ru.test;

import com.github.badoualy.telegram.api.Kotlogram;
import com.github.badoualy.telegram.api.TelegramApiStorage;
import com.github.badoualy.telegram.api.TelegramApp;
import com.github.badoualy.telegram.api.TelegramClient;
import com.github.badoualy.telegram.mtproto.auth.AuthKey;
import com.github.badoualy.telegram.mtproto.model.DataCenter;
import com.github.badoualy.telegram.mtproto.model.MTSession;
import com.github.badoualy.telegram.tl.api.TLUser;
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization;
import com.github.badoualy.telegram.tl.api.auth.TLSentCode;
import com.github.badoualy.telegram.tl.exception.RpcErrorException;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static final int API_ID = 1298484;
    public static final String API_HASH = "b0478f76961851f6897f3983d2a520ae";

    // What you want to appear in the "all sessions" screen
    public static final String APP_VERSION = "1.0";
    public static final String MODEL = "PC";
    public static final String SYSTEM_VERSION = "Windows 10";
    public static final String LANG_CODE = "en";

    public static TelegramApp application = new TelegramApp(API_ID, API_HASH, MODEL, SYSTEM_VERSION, APP_VERSION, LANG_CODE);

    // Phone number used for tests
    public static final String PHONE_NUMBER = "+79032691388"; // International format
    public static void main(String[] args) {
        TelegramClient client = Kotlogram.getDefaultClient(application, new ApiStorage());

// You can start making requests
        try {
            // Send code to account
            TLSentCode sentCode = client.authSendCode(false, PHONE_NUMBER, true);
            System.out.println("Authentication code: ");
            String code = new Scanner(System.in).nextLine();

            // Auth with the received code
            TLAuthorization authorization = client.authSignIn(PHONE_NUMBER, sentCode.getPhoneCodeHash(), code);
            TLUser self = authorization.getUser().getAsUser();
            System.out.println("You are now signed in as " + self.getFirstName() + " " + self.getLastName() + " @" + self.getUsername());
        } catch (RpcErrorException | IOException e) {
            e.printStackTrace();
        } finally {
            client.close(); // Important, do not forget this, or your process won't finish
        }
    }
    public static class ApiStorage implements TelegramApiStorage {

        //Create File variable for auth.key and dc.save
        public static final File AUTH_KEY_FILE = new File("Properties/auth.key");
        public static final File NEAREST_DC_FILE = new File("Properties/dc.save");

        @Override
        public void saveAuthKey(@NotNull AuthKey authKey) {
            try {
                FileUtils.writeByteArrayToFile(AUTH_KEY_FILE, authKey.getKey());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Nullable
        @Override
        public AuthKey loadAuthKey() {
            try {
                return new AuthKey(FileUtils.readFileToByteArray(AUTH_KEY_FILE));
            } catch (IOException e) {
                if (!(e instanceof FileNotFoundException))
                    e.printStackTrace();
            }

            return null;
        }

        @Override
        public void saveDc(@NotNull DataCenter dataCenter) {
            try {
                FileUtils.write(NEAREST_DC_FILE, dataCenter.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Nullable
        @Override
        public DataCenter loadDc() {
            try {
                String[] infos = FileUtils.readFileToString(NEAREST_DC_FILE).split(":");
                return new DataCenter(infos[0], Integer.parseInt(infos[1]));
            } catch (IOException e) {
                if (!(e instanceof FileNotFoundException))
                    e.printStackTrace();
            }

            return null;
        }

        @Override
        public void deleteAuthKey() {
            try {
                FileUtils.forceDelete(AUTH_KEY_FILE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void deleteDc() {
            try {
                FileUtils.forceDelete(NEAREST_DC_FILE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void saveSession(@Nullable MTSession session) {

        }

        @Nullable
        @Override
        public MTSession loadSession() {
            return null;
        }
    }
}
