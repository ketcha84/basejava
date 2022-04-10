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
        for (Resume resume : storage) {
            if (resume.uuid.equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int elementIndex = 0;
        boolean notFound = true;
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                elementIndex = i;
                notFound = false;
                break;
            }
        }
        if (!notFound) {
            for (int i = elementIndex; i < size(); i++) {
                storage[i] = storage[i + 1];
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result;
        int size = size();
        result = new Resume[size];
        for (int i = 0; i < size; i++) {
            result[i] = storage[i];
        }
        return result;
    }

    int size() {
        int iterator = 0;
        while (storage[iterator] != null && iterator < 10000) {
            iterator++;
        }
        return iterator;
    }
}
