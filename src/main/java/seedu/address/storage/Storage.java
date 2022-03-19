package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyLinkyTime;
import seedu.address.model.ReadOnlyUserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends UserPrefsStorage, LinkyTimeStorage {

    @Override
    Optional<JsonAdaptedUserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getLinkyTimeFilePath();

    @Override
    Optional<ReadOnlyLinkyTime> readLinkyTime() throws DataConversionException, IOException;

    @Override
    void saveLinkyTime(ReadOnlyLinkyTime linkyTime) throws IOException;

}
