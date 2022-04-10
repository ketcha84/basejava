/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        add:
        {
            if (size() == 10000) {
                break add;
            } else {
                storage[size()] = new Resume();
                storage[size()].uuid = r.uuid;
            }
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
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        int iterator = 0;
        while (storage[iterator] != null && iterator < 10000) {
            iterator++;
        }
        return iterator;
    }
}
