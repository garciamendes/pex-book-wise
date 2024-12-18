import secureLocalStorage from 'react-secure-storage'

export const useLocalStorage = () => {
  return {
    getItem: (key: string) => secureLocalStorage.getItem(key),
    setItem: (key: string, value: object | boolean | string | number) =>
      secureLocalStorage.setItem(key, value),
    removeItem: (key: string) => secureLocalStorage.removeItem(key),
  }
}