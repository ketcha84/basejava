import javax.swing.*;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            this.storage[i] = null;
        }
    }

    void save(Resume r) {
        if (size() != 10000) {
            int i = size();
            storage[i] = new Resume();
            storage[i].uuid = r.uuid;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (this.storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return new Resume();
    }

    void delete(String uuid) {
        int size = size();
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.arraycopy(this.storage, i + 1, this.storage, i, size - i);
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size = size();
        return Arrays.copyOfRange(this.storage, 0, size);
    }

    int size() {
        int iterator = 0;
        while (this.storage[iterator] != null && iterator < 10000) {
            iterator++;
        }
        return iterator;
    }
}
