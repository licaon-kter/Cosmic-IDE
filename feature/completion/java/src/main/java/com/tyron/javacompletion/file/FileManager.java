/*
 * This file is part of Cosmic IDE.
 * Cosmic IDE is a free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * Cosmic IDE is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with Cosmic IDE. If not, see <https://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Cosmic IDE.
 * Cosmic IDE is a free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * Cosmic IDE is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with Cosmic IDE. If not, see <https://www.gnu.org/licenses/>.
 */

/*
 *  This file is part of CodeAssist.
 *
 *  CodeAssist is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  CodeAssist is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with CodeAssist.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.tyron.javacompletion.file;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.Optional;

/**
 * Manages all files for the same project.
 */
public interface FileManager {
    /**
     * Opens a file and reads its content into a {@link FileSnapshot}.
     *
     * <p>The truth of the file becomes the snapshot.
     */
    void openFileForSnapshot(URI fileUri, String content) throws IOException;

    /**
     * Replace the content of the file snapshot.
     *
     * @param fileUri the URI to identify the file snapshot opened by {@link #openFileForSnapshot}
     * @param newText the new content of the snapshot
     */
    void setSnaphotContent(URI fileUri, String newText);

    /**
     * Watches file changes under {@code rootDirectory} and all its subdirectories.
     */
    void watchSubDirectories(Path rootDirectory);

    /**
     * Sets listener for file changes under watched directories and snapshots.
     */
    void setFileChangeListener(FileChangeListener listener);

    /**
     * Gets the content of a file.
     *
     * <p>If the file is opened for snapshotting by {@link #openFileForSnapshot}, return the content
     * of the snapshot. Otherwise return the content of the file in filesystem.
     */
    Optional<CharSequence> getFileContent(Path filePath);

    /**
     * Shuts down the file manager.
     *
     * <p>All snapshotted files opened by {@link #openFileForSnapshot} will be closed.
     */
    void shutdown();

    /**
     * Whether a given path should be ignored.
     */
    boolean shouldIgnorePath(Path path);

    Path getProjectRootPath();
}
