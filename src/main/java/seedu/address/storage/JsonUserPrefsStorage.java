package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * A class to access UserPrefs stored in the hard disk as a json file
 */
public class JsonUserPrefsStorage implements UserPrefsStorage {

    private final Path filePath;

    public JsonUserPrefsStorage(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public Path getUserPrefsFilePath() {
        return filePath;
    }

    @Override
    public Optional<JsonAdaptedUserPrefs> readUserPrefs() throws DataConversionException {
        return readUserPrefs(filePath);
    }

    /**
     * Similar to {@link #readUserPrefs()}
     * @param prefsFilePath location of the data. Cannot be null.
     * @throws DataConversionException if the file format is not as expected.
     */
    public Optional<JsonAdaptedUserPrefs> readUserPrefs(Path prefsFilePath) throws DataConversionException {
        return JsonUtil.readJsonFile(prefsFilePath, JsonAdaptedUserPrefs.class);
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        final UserPrefs userPrefsToSave = new UserPrefs();
        userPrefsToSave.setGuiSettings(userPrefs.getGuiSettings());
        userPrefsToSave.setLinkyTimeFilePath(userPrefs.getLinkyTimeFilePath());
        final JsonAdaptedUserPrefs jsonAdaptedUserPrefs = new JsonAdaptedUserPrefs(userPrefsToSave);
        JsonUtil.saveJsonFile(jsonAdaptedUserPrefs, filePath);
    }

}
